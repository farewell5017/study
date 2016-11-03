package com.cjt.study.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 检测是否登录
 * 
 * @author 308655
 * @date 2016-8-17 上午9:33:21
 * @since
 * @version
 */
public class CheckLoginFilter implements Filter {

	/**
	 * @author 308655
	 * @date 2016-8-17 上午9:33:49
	 * @param filterConfig
	 * @throws ServletException
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
  
	}

	/**
	 * @author 308655
	 * @date 2016-8-17 上午9:33:49
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		chain.doFilter(request, response);
	}

	/**
	 * @author 308655
	 * @date 2016-8-17 上午9:33:49
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {

	}

}
