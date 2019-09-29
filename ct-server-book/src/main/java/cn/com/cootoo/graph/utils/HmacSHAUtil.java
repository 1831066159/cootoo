package cn.com.cootoo.graph.utils;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Hmac 工具
 *
 * @author zhaoxiang
 * @create 2017/11/10
 **/
public class HmacSHAUtil {
    private static final String ENCODING = "UTF-8";


    public static byte[] HMACSHA1(String encryptText, String encryptKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        return getSignature(encryptText, encryptKey, "HmacSHA1");
    }


    public static byte[] HMACSHA256(String encryptText, String encryptKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        return getSignature(encryptText, encryptKey, "HmacSHA256");
    }


    /**
     * 使用 HMAC-SHA1 签名方法对对encryptText进行签名
     *
     * @param encryptText 被签名的字符
     * @param encryptKey  密钥
     * @param algorithm   算法
     * @return
     * @throws Exception
     */
    public static byte[] getSignature(String encryptText, String encryptKey, String algorithm) throws UnsupportedEncodingException,
            NoSuchAlgorithmException, InvalidKeyException {
        byte[] data = encryptKey.getBytes(ENCODING);
        //根据给定的字节数组构造一个密码串,第二参数指定密钥算法的名称
        SecretKey secretKey = new SecretKeySpec(data, algorithm);
        //生成指定 Mac 算法对象
        Mac mac = Mac.getInstance(algorithm);
        //用给定密钥初始化 Mac 对象  
        mac.init(secretKey);

        byte[] text = encryptText.getBytes(ENCODING);
        //完成 Mac 操作   
        return mac.doFinal(text);
    }
}  