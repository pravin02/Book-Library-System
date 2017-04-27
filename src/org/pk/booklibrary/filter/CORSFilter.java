package org.pk.booklibrary.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * This filter class for cross browser platform.
 * 
 * @author PKORP
 * @since 26/04/2017
 */
public class CORSFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse response = (HttpServletResponse) res;
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
		response.addHeader("Access-Control-Max-Age", "3600");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type");

		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {
	}
}