package com.cjt.study.utils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * 浏览器不缓存
 * 
 * @author 308655
 * @date 2016-8-17 上午9:02:24
 * @since
 * @version
 */
public class ForceNoCacheFilter implements javax.servlet.Filter {

	/**
	 * @author 308655
	 * @date 2016-8-17 上午9:03:41
	 * @param filterConfig
	 * @throws ServletException
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// ServletContext servletContext = filterConfig.getServletContext();
		// String filterName = filterConfig.getFilterName();
		// System.out.println("filterName:" + filterName);
		// String devName = servletContext.getInitParameter("devName");
		// System.out.println("devName:" + devName);
		@SuppressWarnings("unchecked")
		Enumeration<String> enumeration = filterConfig.getInitParameterNames();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		while (enumeration.hasMoreElements()) {
			String nextElement = enumeration.nextElement();
			hashMap.put(nextElement, filterConfig.getInitParameter(nextElement));
		}
		// System.out.println("全部初始化参数:" + hashMap.toString());
		// System.out.println("ForceNoCacheFilter初始化...");
	}

	/**
	 * @author 308655
	 * @date 2016-8-17 上午9:03:41
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
		((HttpServletResponse) response).setHeader("Cache-Control", "no-cache");
		((HttpServletResponse) response).setHeader("Pramga", "no-cache");
		((HttpServletResponse) response).setDateHeader("Expires", 0);
		// System.out.println("ForceNoCacheFilter执行前...");
		chain.doFilter(request, response);
		// System.out.println("ForceNoCacheFilter执行后...");
	}

	/**
	 * @author 308655
	 * @date 2016-8-17 上午9:03:41
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("ForceNoCacheFilter销毁...");
	}

}
