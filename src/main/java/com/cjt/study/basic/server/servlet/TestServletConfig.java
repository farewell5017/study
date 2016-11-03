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
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 308655
 * @date 2016-8-19 下午4:36:59
 * @since
 * @version
 */
public class TestServletConfig extends HttpServlet {
	private static final long serialVersionUID = 1460842392617124733L;

	/**
	 * @author 308655
	 * @date 2016-8-19 下午4:39:04
	 * @param config
	 * @throws ServletException
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @author 308655
	 * @date 2016-8-19 下午4:37:21
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		// ServletContext servletContext = servletConfig.getServletContext();
		// servletConfig.
		// writer.write(servletConfig.getInitParameter("姓名"));
		// writer.write("getServletName:" + servletConfig.getServletName()
		// + "\r\n");
		// writer.write("getContextPath:" + servletContext.getContextPath()
		// + "\r\n");
		// writer.write("getMajorVersion:" + servletContext.getMajorVersion()
		// + "\r\n");

		// resp.addHeader("Content-Length",file.length);//设置下载文件大小

		// resp.setContentType("application/octet-stream");//设置文件类型
		// ServletOutputStream outputStream = resp.getOutputStream();
		//
		// InputStream inputStream = servletContext
		// .getResourceAsStream("/WEB-INF/readFile.txt");
		// InputStreamReader inputStreamReader = new InputStreamReader(
		// inputStream, "UTF-8");
		// StringBuffer sb = new StringBuffer();
		// int temp = 0;
		// while ((temp = inputStream.read()) != -1) {
		// outputStream.write(temp);
		// }
		// outputStream.write("崔大发:620160315/r/n崔大发: wwwww/r/n620160317"
		// .getBytes("utf-8"));
		// outputStream.close();
		PrintWriter writer = resp.getWriter();
		writer.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
		writer.write("擦擦擦!");
		writer.close();
	}

	/**
	 * @author 308655
	 * @date 2016-8-19 下午4:37:28
	 * @see
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
