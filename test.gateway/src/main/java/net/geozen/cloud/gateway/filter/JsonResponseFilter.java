package net.geozen.cloud.gateway.filter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_RESPONSE_FILTER_ORDER;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import net.geozen.cloud.base.dto.ResultBean;

@Component
public class JsonResponseFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return POST_TYPE;
	}

	@Override
	public int filterOrder() {
		return SEND_RESPONSE_FILTER_ORDER - 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		if (context.getResponseStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
			String traceId = (String) context.get(TracePreFilter.TRACE_ID_ATTR);
			try {
				context.setResponseBody(new ObjectMapper().writeValueAsString(new ResultBean<>(traceId, "Internal error")));
			} catch (Exception e) {
				context.setResponseBody("{\"msg\":\"Internal error\", \"traceId\":\"" + traceId + "\"");
			}
		}
		return null;
	}
}
