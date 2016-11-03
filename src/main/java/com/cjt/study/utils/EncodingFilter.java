package com.cjt.study.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * Servlet Filter implementation class encodingFilter
 */
public class EncodingFilter implements javax.servlet.Filter {
	private String encoding;

	/**
	 * Default constructor.
	 */
	public EncodingFilter() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (StringUtils.isNotBlank(encoding)) {
			((HttpServletRequest) request).setCharacterEncoding(encoding);
			((HttpServletResponse) response).setCharacterEncoding(encoding);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String encode = fConfig.getInitParameter("encoding");
		this.encoding = encode;
	}

}
