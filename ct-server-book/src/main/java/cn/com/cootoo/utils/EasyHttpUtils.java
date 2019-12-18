package cn.com.cootoo.utils;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: http公用方法
 * @CreateDate: 2016/6/7
 */
public class EasyHttpUtils {

    private static final Logger LOG = LoggerFactory.getLogger(EasyHttpUtils.class);

    //上传文件时 每个post请求参数之间的分隔
    private static final String BOUNDARY = "------WebKitFormBoundary";

    private static final String PROTOCOL_SSLV3 = "SSLv3";//任何版本的TLS都比SSLv3安全
    private static final String PROTOCOL_TLS = "TLSv1.2";//支持所有协议

    private static final int MAX_TOTAL = 100;
    private static final int DEFAULT_MAX_PER_ROUTE = 200;
    private static final int CONNECT_TIME_OUT = 60000;
    private static final int SOCKET_TIME_OUT = 180000;

    private static CloseableHttpClient httpClient;

    static {
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", new SSLConnectionSocketFactory(createSSLContextTLS()))
                .build();
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);

        connManager.setMaxTotal(MAX_TOTAL);
        connManager.setDefaultMaxPerRoute(DEFAULT_MAX_PER_ROUTE);
//        connManager.closeIdleConnections(20, TimeUnit.SECONDS);

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(CONNECT_TIME_OUT)
                .setSocketTimeout(SOCKET_TIME_OUT).build();

        // 请求重试处理
        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {

                if (executionCount >= 3) {// 如果已经重试了3次，就放弃
                    return false;
                }
                if (exception instanceof NoHttpResponseException) {// 如果服务器丢掉了连接，那么就重试
                    LOG.info("httpclient请求重试处理:count={},msg={}", executionCount, exception.getMessage());
                    return true;
                }
                if (exception instanceof SSLHandshakeException) {// 不重试SSL握手异常
                    return false;
                }
                if (exception instanceof InterruptedIOException) {// 超时不重试
                    return false;
                }
                if (exception instanceof UnknownHostException) {// 目标服务器不可达不重试
                    return false;
                }
                if (exception instanceof ConnectTimeoutException) {// 连接被拒绝不重试
                    return false;
                }
                if (exception instanceof SSLException) {// SSL握手异常不重试
                    return false;
                }
                HttpClientContext clientContext = HttpClientContext.adapt(context);
                HttpRequest request = clientContext.getRequest();
                // 如果请求是幂等的，就再次尝试
                if (!(request instanceof HttpEntityEnclosingRequest)) {
                    return true;
                }
                return false;
            }
        };

        httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .setRetryHandler(httpRequestRetryHandler)
                .setConnectionManager(connManager).build();
    }

    private EasyHttpUtils() {

    }

    public static String post(String url, Map<String, String> paramMap, Map<String, byte[]> fileMap) throws IOException {
        return post(url, paramMap, fileMap, null);
    }

    /**
     * 带文件的post请求
     *
     * @param url      url
     * @param paramMap 参数
     * @param fileMap  文件参数
     * @return
     * @throws IOException
     */
    public static String post(String url, Map<String, String> paramMap, Map<String, byte[]> fileMap,
                              Map<String, List<byte[]>> fileArrayMap)
            throws IOException {
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "multipart/form-data;charset=utf-8;boundary=" + BOUNDARY);
        MultipartEntityBuilder builder = setParam(paramMap, fileMap, fileArrayMap);
        post.setEntity(builder.build());
        HttpResponse response = httpClient.execute(post);
        return EntityUtils.toString(response.getEntity(), "UTF-8");
    }

    /**
     * 带文件的post 塞参数
     *
     * @param paramMap
     * @param fileMap
     */
    private static MultipartEntityBuilder setParam(Map<String, String> paramMap, Map<String, byte[]> fileMap,
                                                   Map<String, List<byte[]>> fileArrayMap) {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setBoundary(BOUNDARY);
        if (null != paramMap && !paramMap.isEmpty()) {
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                builder.addTextBody(entry.getKey(), entry.getValue(),
                        ContentType.create("application/x-www-form-urlencoded", Consts.UTF_8));
            }
        }
        if (null != fileMap && !fileMap.isEmpty()) {
            for (Map.Entry<String, byte[]> entry : fileMap.entrySet()) {
                //在上传文件的时候必须得加上ContentType
                builder.addBinaryBody(entry.getKey(), entry.getValue(), ContentType.MULTIPART_FORM_DATA, "");
            }
        }
        if (null != fileArrayMap && !fileArrayMap.isEmpty()) {
            for (Map.Entry<String, List<byte[]>> entry : fileArrayMap.entrySet()) {
                List<byte[]> list = entry.getValue();
                if (null != list) {
                    for (byte[] bytes : entry.getValue()) {
                        builder.addBinaryBody(entry.getKey(), bytes, ContentType.MULTIPART_FORM_DATA, "");
                    }
                }
            }
        }
        return builder;
    }

    /**
     * post json 请求
     *
     * @param url
     * @param jsonStr
     * @return
     * @throws IOException
     */
    public static String postJson(String url, String jsonStr) throws IOException {
        if (StringUtils.isEmpty(url)) {
            return "url不能为空";
        }
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-type", "application/json");
        HttpEntity httpEntity = new StringEntity(jsonStr, "UTF-8");
        post.setEntity(httpEntity);
        HttpResponse response = httpClient.execute(post);
        return EntityUtils.toString(response.getEntity());
    }

    /**
     * post 请求
     *
     * @param url
     * @param paramMap
     * @return
     * @throws IOException
     */
    public static String post(String url, Map<String, String> paramMap) throws IOException {
        if (StringUtils.isEmpty(url)) {
            return "url不能为空";
        }
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        if (null != paramMap && !paramMap.isEmpty()) {
            List<NameValuePair> params = getNameValuePair(paramMap);
            post.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
        }
        HttpResponse response = httpClient.execute(post);
        return EntityUtils.toString(response.getEntity());
    }

    public static String get(String url) throws IOException {
        if (StringUtils.isEmpty(url)) {
            return "url不能为空";
        }
        HttpGet get = new HttpGet(url);
        HttpResponse response = httpClient.execute(get);
        return EntityUtils.toString(response.getEntity());
    }


    private static final int REQUEST_TIMEOUT = 3 * 1000; // 从连接池中获取到连接的最长时间
    private static final int TIMEOUT = 5 * 1000; // 连接超时时间
    private static final int SO_TIMEOUT = 15 * 1000; // 数据传输超时
    private static final String CHARSET = "UTF-8";

    /**
     * GET方式请求数据
     *
     * @param url url
     */
    public static String doGet(String url, Map<String, String> header) {
        HttpGet httpGet = new HttpGet(url);
        if (header != null && header.size() > 0) {
            for (String key : header.keySet()) {
                httpGet.setHeader(key, header.get(key));
            }
        }
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(SO_TIMEOUT)
                .setConnectTimeout(TIMEOUT)
                .setConnectionRequestTimeout(REQUEST_TIMEOUT)
                .build();
        httpGet.setConfig(requestConfig);

        String responseContent; // 响应内容
        String strRep = null;
        try {
            // 执行get请求
            HttpResponse httpResponse = httpClient.execute(httpGet);
            // 获取响应消息实体
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                responseContent = EntityUtils.toString(entity, CHARSET);// 不能重复调用此方法，IO流已关闭。
                strRep = responseContent;
                // 获取HTTP响应的状态码
                //int statusCode = httpResponse.getStatusLine().getStatusCode();

                /*if (statusCode == HttpStatus.SC_OK) {
                    strRep = responseContent; // EntityUtils.toString(httpResponse.getEntity());
                }*/
                // Consume response content
                EntityUtils.consume(entity);
                // Do not need the rest
                httpGet.abort();
            }
        } catch (ClientProtocolException e) {
            LOG.error("ClientProtocolException", e);
        } catch (UnsupportedEncodingException e) {
            LOG.error("UnsupportedEncodingException", e);
        } catch (ConnectTimeoutException e) {
            LOG.error("ConnectTimeoutException", e);
        } catch (SocketTimeoutException e) {
            LOG.error("SocketTimeoutException", e);
        } catch (Exception e) {
            LOG.error("Exception", e);
        } finally {
            httpGet.releaseConnection();
        }

        return strRep;
    }

    /**
     * 指定参数名POST- JSON 方式请求数据
     *
     * @param url
     * @param header
     * @param json
     * @return
     */
    public static String doPostJson(String url, Map<String, String> header, String json) {
        return doPost(url, header, null, json);
    }


    /**
     * 指定参数名POST方式请求数据
     *
     * @param url
     * @param header
     * @param paramsMap
     * @return
     */
    public static String doPost(String url, Map<String, String> header, Map<String, String> paramsMap) {
        return doPost(url, header, paramsMap, null);
    }

    /**
     * 指定参数名POST方式请求数据, 支持: map参数 和 json|xml参数
     *
     * @param url           url
     * @param header        header
     * @param paramsMap     map参数
     * @param jsonXMLString json|xml参数
     * @return
     */
    private static String doPost(String url, Map<String, String> header, Map<String, String> paramsMap, String jsonXMLString) {
        HttpPost httpPost = new HttpPost(url);
        if (header != null && header.size() > 0) {
            for (String key : header.keySet()) {
                httpPost.setHeader(key, header.get(key));
            }
        }
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(SO_TIMEOUT)
                .setConnectTimeout(TIMEOUT)
                .setConnectionRequestTimeout(REQUEST_TIMEOUT)
                .setExpectContinueEnabled(false)
                .build();
        httpPost.setConfig(requestConfig);

        String responseContent;
        String strRep = null;
        try {
            if (paramsMap != null && jsonXMLString == null) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(getParamsList(paramsMap), CHARSET);
                httpPost.setEntity(entity);
            } else {
                httpPost.setEntity(new StringEntity(jsonXMLString, CHARSET));
            }
            // 执行post请求
            HttpResponse httpResponse = null;
            try {
                httpResponse = httpClient.execute(httpPost);

            } catch (Exception e) {
                if (e instanceof NoHttpResponseException
                        || e instanceof ConnectTimeoutException
                        || e instanceof SocketTimeoutException) {
                    LOG.info("重试操作开始");
                    httpResponse = httpClient.execute(httpPost);
                    LOG.info("重试操作成功");
                } else {
                    LOG.error("发送失败，错误消息={}", e);
                }
            }

            // 获取响应消息实体
            HttpEntity entityRep = httpResponse.getEntity();//NOSONAR
            if (entityRep != null) {
                responseContent = EntityUtils.toString(httpResponse.getEntity(), CHARSET);
                // 获取HTTP响应的状态码
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                if (statusCode == HttpStatus.SC_OK) {
                    strRep = responseContent;
                } else if ((statusCode == HttpStatus.SC_MOVED_TEMPORARILY)
                        || (statusCode == HttpStatus.SC_MOVED_PERMANENTLY)
                        || (statusCode == HttpStatus.SC_SEE_OTHER)
                        || (statusCode == HttpStatus.SC_TEMPORARY_REDIRECT)) {
                    // 重定向处理，获得跳转的网址
                    Header locationHeader = httpResponse.getFirstHeader("Location");
                    if (locationHeader != null) {
                        String successUrl = locationHeader.getValue();
                    }
                }

                // Consume response content
                EntityUtils.consume(entityRep);
                // Do not need the rest
                httpPost.abort();
            }
        } catch (ClientProtocolException e) {
            LOG.error("ClientProtocolException", e);
        } catch (UnsupportedEncodingException e) {
            LOG.error("UnsupportedEncodingException", e);
        } catch (ConnectTimeoutException e) {
            LOG.error("ConnectTimeoutException", e);
        } catch (SocketTimeoutException e) {
            LOG.error("SocketTimeoutException", e);
        } catch (Exception e) {
            LOG.error("Exception", e);
        } finally {
            httpPost.releaseConnection();
        }

        return strRep;
    }

    /**
     * 将传入的键/值对参数转换为NameValuePair参数集
     *
     * @param paramsMap 参数集, 键/值对
     * @return NameValuePair参数集
     */
    private static List<NameValuePair> getParamsList(Map<String, String> paramsMap) {
        if (paramsMap == null || paramsMap.size() == 0) {
            return new ArrayList<NameValuePair>();
        }
        // 创建参数队列
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> map : paramsMap.entrySet()) {
            params.add(new BasicNameValuePair(map.getKey(), map.getValue()));
        }
        return params;
    }

    /**
     * @param url
     * @return
     * @throws IOException
     */
    public static InputStream getInputStream(String url) throws IOException {
        if (StringUtils.isEmpty(url)) {
            return null;
        }
        HttpGet get = new HttpGet(url);
        HttpResponse response = httpClient.execute(get);
        return response.getEntity().getContent();
    }

    /**
     * 参数转换 Map<String,String> ==》List<NameValuePair>
     *
     * @param paramMap
     * @return
     */
    public static List<NameValuePair> getNameValuePair(Map<String, String> paramMap) {
        List<NameValuePair> params = new ArrayList<>();
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return params;
    }

    /**
     * 创建SSLContext SSLv3
     *
     * @return SSLContext
     */
    private static SSLContext createSSLContextSSLv3() {
        return createSSLContext(PROTOCOL_SSLV3);
    }

    /**
     * 创建SSLContext TLS
     *
     * @return
     */
    private static SSLContext createSSLContextTLS() {
        return createSSLContext(PROTOCOL_TLS);
    }

    /**
     * 创建SSLContext
     *
     * @param protocol 协议
     * @return SSLContext
     */
    private static SSLContext createSSLContext(String protocol) {
        SSLContext context = null;
        try {
            context = SSLContext.getInstance(protocol);
            context.init(null, new TrustManager[]{getTrustManager()}, null);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            LOG.error("创建SSLContext失败", e);
        }
        return context;
    }

    /**
     * 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
     *
     * @return X509TrustManager
     */
    private static X509TrustManager getTrustManager() {
        return new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
    }

}
