package com.cjt.study.basic.server.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowPictureServlet extends HttpServlet {
	private static final long serialVersionUID = -6704870009322656979L;

	@SuppressWarnings("resource")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/png;charset=UTF-8");
		ServletOutputStream outputStream = resp.getOutputStream();
		String realPath = this.getServletContext().getRealPath("/image/20160803180055228.gif");
		FileInputStream fileInputStream = new FileInputStream(new File(realPath));
		byte[] b = new byte[1024];
		int length = 0;
		while ((length = fileInputStream.read(b)) != -1) {
			outputStream.write(b, 0, length);
		}
		outputStream.flush();
		outputStream.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
