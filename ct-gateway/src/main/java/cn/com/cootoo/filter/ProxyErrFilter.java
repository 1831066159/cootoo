package cn.com.cootoo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ERROR_TYPE;

/**
 * @author
 *         异常处理filter 作废
 */
//@Service
public class ProxyErrFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(ProxyErrFilter.class);

    @Override
    public String filterType() {
        return ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return -2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();

        String tx = (String) ctx.get("cto.tx");
        req.setAttribute("cto.proxy.oriURI", req.getRequestURL());
        req.setAttribute("cto.proxy.routeHost", ctx.getRouteHost());
        req.setAttribute("cto.tx", tx);


        long t2 = System.currentTimeMillis();

        logger.warn("[cto.tx:{}]<<< proxy failed,usedTime:{}"
                , tx, t2 - (long) ctx.get("cto.tx.t1"));

        return null;
    }

}
