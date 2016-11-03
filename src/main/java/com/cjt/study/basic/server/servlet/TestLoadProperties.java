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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 308655
 * @date 2016-8-17 下午6:06:45
 * @since
 * @version
 */
public class TestLoadProperties extends HttpServlet {
	private static final long serialVersionUID = -6766108557579544640L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		@SuppressWarnings("unused")
		InputStream resourceAsStream = this.getClass().getClassLoader()
				.getResourceAsStream("com/deppon/cjt/module/test-push/20160803180055228.gif");

		// InputStreamReader reader = new InputStreamReader(resourceAsStream,
		// "UTF-8");
		// Properties properties = new Properties();
		// properties.load(reader);
		// String driver = properties.getProperty("driver");
		// req.setAttribute("driver", driver);
		// String username = properties.getProperty("username");
		// req.setAttribute("username", username);
		// String password = properties.getProperty("password");
		// req.setAttribute("password", password);
		// RequestDispatcher dispatcher = req
		// .getRequestDispatcher("/WEB-INF/testjsp/forward.jsp");
		// dispatcher.forward(req, resp);
		// 获取图片绝对路径
		String path = this.getServletContext().getRealPath("/");
		System.out.println(path);
		// File file = new File(path + "/images/WIN_20131027_214421.JPG");
		File file = new File(this.getClass().getClassLoader().getResource("").getPath()
				+ "com/deppon/cjt/module/test-push/20160803180055228.gif");
		resp.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
		// 创建文件输入流
		FileInputStream is = new FileInputStream(file);
		// 响应输出流
		ServletOutputStream out = resp.getOutputStream();
		// 创建缓冲区
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = is.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}
		is.close();
		out.flush();
		out.close();
	}
}
