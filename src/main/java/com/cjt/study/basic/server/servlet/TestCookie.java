/*
 * Copyright by Deppon and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about Deppon from
 *
 *      http://www.deppon.com
 *
 */
package com.cjt.study.basic.server.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 308655
 * @date 2016-8-22 下午4:17:01
 * @since
 * @version
 */
public class TestCookie extends HttpServlet {

	private static final long serialVersionUID = 6862674708951460728L;

	/**
	 * @author 308655
	 * @date 2016-8-22 下午4:17:27
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("deprecation")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		if (cookies != null && cookies.length != 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName() != null && cookie.getName().equals("lastTime")) {
					req.setAttribute("lastTime", URLDecoder.decode(cookie.getValue(), "utf-8"));
//					System.out.println("getComment:" + cookie.getComment());
//					System.out.println("getDomain:" + cookie.getDomain());
//					System.out.println("getMaxAge:" + cookie.getMaxAge());
//					System.out.println("getPath:" + cookie.getPath());
//					System.out.println("getVersion:" + cookie.getVersion());
//					System.out.println("getSecure:" + cookie.getSecure());
				}
			}

		} else {
			req.setAttribute("lastTime", "第一次访问!");
		}
		// resp.setHeader("refresh", 1 + "");
		Cookie cookie1 = new Cookie("lastTime", URLEncoder.encode("上次访问时间:" + new Date().toLocaleString(), "utf-8"));
		resp.addCookie(cookie1);
		resp.addCookie(new Cookie("name", URLEncoder.encode("崔家腾", "utf-8")));
		this.getServletContext().getRequestDispatcher("/WEB-INF/testjsp/forward.jsp").forward(req, resp);
	}

	/**
	 * @author 308655
	 * @date 2016-8-22 下午4:17:33
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
