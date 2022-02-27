package cn.com.cootoo.graph.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author system
 * @create 2019/8/16
 **/
public class FilterWarper extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(FilterWarper.class);

    @Override
    public String filterType() {
        logger.info("");
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * 设置过滤条件
     */
    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().getRouteHost() != null
                && RequestContext.getCurrentContext().sendZuulResponse();
    }


    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String nn = request.getParameter("nn");
        Map<String, List<String>> requestQueryParams = context.getRequestQueryParams();

        if (requestQueryParams==null) {
            requestQueryParams=new HashMap<>();
        }

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(nn);
        requestQueryParams.put("nn", arrayList);
        context.setRequestQueryParams(requestQueryParams);

        return null;

    }
}
