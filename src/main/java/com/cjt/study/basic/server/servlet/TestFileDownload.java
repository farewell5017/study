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

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * @author 308655
 * @date 2016-8-20 上午10:15:13
 * @since
 * @version
 */
public class TestFileDownload extends HttpServlet {

	private static final long serialVersionUID = 4632826496055692507L;

	/**
	 * @author 308655
	 * @date 2016-8-20 上午10:16:32
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// PrintWriter out = resp.getWriter();
		// out.println("contextPath=" +
		// this.getServletContext().getContextPath());
		// out.println("getRealPath="
		// + this.getServletContext().getRealPath("WEB-INF/web.xml"));
		// out.println("getServletContextName="
		// + this.getServletContext().getServletContextName());
		// out.println("getResource="
		// + this.getServletContext().getResource("/index.jsp"));
		// out.close();
		resp.setContentType("multipart/form-data");
		// 获取文件真实路径
		String flag = req.getParameter("fileName");
		String realPath = null;
		if (StringUtils.isBlank(flag)) {
			realPath = this.getServletConfig().getServletContext().getRealPath("/image/逗比美女.jpg");
		} else {
			flag = new String(flag.getBytes("iso8859-1"), "UTF-8");
			realPath = this.getServletConfig().getServletContext().getRealPath("/WEB-INF/files/" + flag);
		}
		File file = new File(realPath);
		if (file.exists() && file.isFile()) {
			// 文件名
			String fileName = file.getName();
			resp.setHeader("content-disposition",
					"attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
			// 输入流
			FileInputStream fileInputStream = new FileInputStream(file);
			// InputStream fileInputStream = this.getServletContext()
			// .getResourceAsStream("/WEB-INF/image/逗比美女.jpg");
			int len = 0;
			// 输出流
			ServletOutputStream outputStream = resp.getOutputStream();
			byte[] bArr = new byte[1024];
			while ((len = fileInputStream.read(bArr)) != -1) {
				outputStream.write(bArr, 0, len);
				bArr = new byte[1024];
			}
			fileInputStream.close();
			outputStream.flush();
			outputStream.close();
		}
	}

	/**
	 * @author 308655
	 * @date 2016-8-20 上午10:16:37
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
