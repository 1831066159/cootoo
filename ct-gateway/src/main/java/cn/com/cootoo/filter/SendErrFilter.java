/*
 * Copyright 2013-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.com.cootoo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import cn.com.cootoo.ProxyHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ERROR_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_ERROR_FILTER_ORDER;

/**
 * 异常跳转到ErrorController
 */
@Service
public class SendErrFilter extends ZuulFilter {

	private static final Logger log = LoggerFactory.getLogger(SendErrFilter.class);
	protected static final String ORI_SEND_ERROR_FILTER_RAN = "sendErrorFilter.ran";
	protected static final String SEND_ERROR_FILTER_RAN = "cto.sendErrorFilter.ran";

	@Value("${error.path:/error}")
	private String errorPath;

	@Override
	public String filterType() {
		return ERROR_TYPE;
	}

	@Override
	public int filterOrder() {
		return SEND_ERROR_FILTER_ORDER-1;
	}

	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		// only forward to errorPath if it hasn't been forwarded to already
		return ctx.getThrowable() != null && !ctx.getBoolean(SEND_ERROR_FILTER_RAN, false);
	}

	@Override
	public Object run() {
		try {

			RequestContext ctx = RequestContext.getCurrentContext();

			//XXX 禁用原生的SendErrorFilter
			ctx.set(ORI_SEND_ERROR_FILTER_RAN,true);

			ZuulException exception = findZuulException(ctx.getThrowable());
			HttpServletRequest request = ctx.getRequest();

			String tx = (String) ctx.get("cto.tx");

			request.setAttribute("javax.servlet.error.status_code", exception.nStatusCode);

			request.setAttribute("cto.proxy.oriURI",request.getRequestURL());
			request.setAttribute("cto.proxy.routeHost",ctx.getRouteHost());
			request.setAttribute("cto.tx",tx);

			long t2 = System.currentTimeMillis();

			log.warn("[cto.tx:{}]<<< proxy failed,usedTime:{}" ,tx,t2-(long)ctx.get("cto.tx.t1"));

			if(ProxyHelper.isCausedBy(exception,"Broken pipe")
					|| ProxyHelper.isCausedBy(exception,"Connection reset by peer") ){
				//TODO 如果是请求端连接断开了，忽略这种异常, Caused by: java.io.IOException: Broken pipe
				//Caused by: java.io.IOException: Connection reset by peer
				log.warn("[cto.tx:{}]<<< 请求端中断了连接(Broken pipe/Connection reset by peer)",tx);

				if (!ctx.getResponse().isCommitted()) {
					try{
						ctx.getResponse().getOutputStream().close();
					}catch (Exception e){//NOSONAR 忽略这里的异常
						//NOSONAR 忽略这里的异常
					}
				}
				return null;
			}

			log.warn("[cto.tx:{}]<<< error during filtering",tx,exception);

			request.setAttribute("javax.servlet.error.exception", exception);

			if (StringUtils.hasText(exception.errorCause)) {
				request.setAttribute("javax.servlet.error.message", exception.errorCause);
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher(this.errorPath);
			if (dispatcher != null) {
				ctx.set(SEND_ERROR_FILTER_RAN, true);
				if (!ctx.getResponse().isCommitted()) {
					ctx.setResponseStatusCode(exception.nStatusCode);
					dispatcher.forward(request, ctx.getResponse());
				}
			}
		} catch (Exception ex) {
			ReflectionUtils.rethrowRuntimeException(ex);
		}
		return null;
	}

	ZuulException findZuulException(Throwable throwable) {
		if (throwable.getCause() instanceof ZuulRuntimeException) {
			// this was a failure initiated by one of the local filters
			return (ZuulException) throwable.getCause().getCause();
		}

		if (throwable.getCause() instanceof ZuulException) {
			// wrapped zuul exception
			return (ZuulException) throwable.getCause();
		}

		if (throwable instanceof ZuulException) {
			// exception thrown by zuul lifecycle
			return (ZuulException) throwable;
		}

		// fallback, should never get here
		return new ZuulException(throwable, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, null);
	}

	public void setErrorPath(String errorPath) {
		this.errorPath = errorPath;
	}

}
