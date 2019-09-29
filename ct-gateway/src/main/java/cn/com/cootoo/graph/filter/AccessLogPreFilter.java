package cn.com.cootoo.graph.filter;


import cn.com.cootoo.graph.ProxyHelper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Service
public class AccessLogPreFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(AccessLogPreFilter.class);

    private UrlPathHelper urlPathHelper = new UrlPathHelper();

    @Autowired
    private RouteLocator routeLocator;

    @Autowired
    private ProxyHelper proxyHelper;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        String tx = System.currentTimeMillis() + "-" + RandomStringUtils.randomAlphabetic(4);

        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.set("cto.tx", tx);
        ctx.set("cto.tx.t1", System.currentTimeMillis());

        final String requestURI = this.urlPathHelper.getPathWithinApplication(ctx.getRequest());
        Route route = this.routeLocator.getMatchingRoute(requestURI);
        HttpServletRequest req = ctx.getRequest();
        logger.info("[cto.tx:{}]>>>routing for Request," +
                        "clientIp:{}|remoteAddr:{}|remotePort:{}" +
                        "|protocol:{}|method:{}|url:{}" +
                        "|queryString:{}|" +
                        "|headers:{}|zuulHeaders:{}"
                , tx
                , proxyHelper.getClientRealIp()
                , req.getRemoteAddr(), req.getRemotePort()
                , req.getProtocol(), req.getMethod(), req.getRequestURL()
                , req.getQueryString()
//                ,JSON.toJSON(req.getCookies())
                , proxyHelper.getReqHeaders(req)
                , ctx.getZuulRequestHeaders());

        if (route == null) {
            logger.info("[cto.tx:{}]>>> not find matched service provider", tx);
        } else {
            logger.info("[cto.tx:{}]>>> matched service provider: {}", tx, route);
        }
        return null;
    }
}
