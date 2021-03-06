package net.geozen.cloud.gateway.filter;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

@Component
public class LoggingFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			HttpServletRequest req = (HttpServletRequest) request;
			String url = req.getRequestURI();
			if (req.getQueryString() != null) {
				url += req.getQueryString();
			}
			MDC.put("requestUri", url);
			String clientIP = req.getHeader("X-Forwarded-For");
			if (StringUtils.isEmpty(clientIP)) {
				clientIP = req.getRemoteAddr();
			}
			MDC.put("clientIP", clientIP);
			MDC.put("hostIP", InetAddress.getLocalHost().getHostAddress());
			chain.doFilter(request, response);
		} finally {
			MDC.clear();
		}
	}

}
