package cn.com.cootoo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import cn.com.cootoo.ProxyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

/**
 * 填充Proxy Header
 *
 * @author
 */
@Service
public class ProxyHeaderFilter extends ZuulFilter {

    @Autowired
    private ProxyHelper proxyHelper;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return !ctx.containsKey(FORWARD_TO_KEY) // a filter has already forwarded
                && !ctx.containsKey(SERVICE_ID_KEY); // a filter has already determined serviceId
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();

        ctx.addZuulRequestHeader("X-Real-IP", proxyHelper.getClientRealIp());

        return null;
    }
}
