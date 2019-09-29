package cn.com.cootoo.graph;

import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.X_FORWARDED_FOR_HEADER;

@Service
public class ProxyHelper {

    private static Logger logger = LoggerFactory.getLogger(ProxyHelper.class);


    public static boolean isCausedBy(Throwable t ,String causedEmsg){
        while(t!=null){
            if(t.getMessage()!=null && t.getMessage().contains(causedEmsg)){
                return true;
            }
            t = t.getCause();
        }
        return false;
    }


    public static boolean isCausedBy(Throwable t ,Class c){
        while(t!=null){
            if(c.isAssignableFrom(t.getClass())){
                return true;
            }
            t = t.getCause();
        }
        return false;
    }

    public Map<String,Object> getReqHeaders(HttpServletRequest req){
        Map<String,Object> map = new HashMap<>();
        Enumeration<String> names = req.getHeaderNames();
        if(names!=null){
            while(names.hasMoreElements()){
                String n = names.nextElement();
                List<String> value = new ArrayList<>(10);
                Enumeration<String> vs = req.getHeaders(n);
                while(vs!=null && vs.hasMoreElements()){
                    value.add(vs.nextElement());
                }
                map.put(n,value);
            }
        }

        return map;
    }


    public Map<String,Object> getRespHeaders(HttpServletResponse resp){

        Map<String,Object> map = new HashMap<>();
        Collection<String> names = resp.getHeaderNames();
        if(names!=null){
            for(String n : names){
                map.put(n,resp.getHeaders(n));
            }
        }
        return map;
    }

    public String getClientRealIp(){
        RequestContext ctx = RequestContext.getCurrentContext();
        String realIp = ctx.getRequest().getHeader("X-Real-IP");
        String remoteAddr = ctx.getRequest().getRemoteAddr();
        String xforwardedfor = ctx.getRequest().getHeader(X_FORWARDED_FOR_HEADER);

        logger.debug("requestHeader----- realIp:{},remoteAddr:{},xff:{}",realIp,remoteAddr,xforwardedfor);

        if(StringUtils.isBlank(realIp)){
            if (StringUtils.isBlank(xforwardedfor)) {
                xforwardedfor = remoteAddr;
            }

            String[] ips = xforwardedfor.split(",");
            realIp = ips[ips.length-1];
        }
        return realIp;
    }
}
