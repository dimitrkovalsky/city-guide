package com.guide.city.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthenticationFilter implements Filter {

	public void doFilter(ServletRequest servletRequest,
			ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
//
//		HttpServletRequest request = (HttpServletRequest) servletRequest;
//		
//		if (request.getSession().getAttribute(SESSION_NAME) == null) {
//			request.getRequestDispatcher("/login").forward(request, response);
//			return;
//		} 
		
		chain.doFilter(servletRequest, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}
}
