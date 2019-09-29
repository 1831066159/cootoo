package cn.com.cootoo.graph.filter;

import cn.com.cootoo.graph.ProxyHelper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

@Service
public class AccessLogPostFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(AccessLogPostFilter.class);

    @Autowired
    private ProxyHelper proxyHelper;

    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 999;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();

        String tx = (String) ctx.get("cto.tx");
        long t1 = (long)ctx.get("cto.tx.t1");
        long t2 = System.currentTimeMillis();

        HttpServletResponse resp = ctx.getResponse();

        if(resp!=null){

            logger.info("[cto.tx:{}]<<< after routing,responseInfo: " +
                            "respHttpStatus:{}|contentType:{}|,encoding:{}|respHeaders:{}",tx

                    ,resp.getStatus(),resp.getContentType()
                    ,resp.getCharacterEncoding()
                    ,proxyHelper.getRespHeaders(resp)

            );
        }else{
            logger.info("[cto.tx:{}]<<< after routing, response is NULL",tx);
        }

        logger.info("[cto.tx:{}]<<< after routing,routeInfo usedTime:{}|ctxStatus:{}|filterSummary:{}|routeHost:{}"//|zuulRespHeader:{}
                ,tx
                ,t2-t1
                ,ctx.getResponseStatusCode()
                ,ctx.getFilterExecutionSummary()
                ,ctx.getRouteHost()
//                ,ctx.getZuulResponseHeaders()
        );

        return null;
    }

}
