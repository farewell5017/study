package com.cjt.study.basic.server.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 8355768794997760771L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String realPath = getServletContext().getRealPath("/WEB-INF/files");
		File file = new File(realPath);
		ArrayList<String> files = new ArrayList<String>();
		listFile(file, files);
		req.setAttribute("files", files);
		req.getRequestDispatcher("/WEB-INF/testjsp/downloadfile.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	private void listFile(File file, List<String> files) {
		if (null != file) {
			if (file.isDirectory()) {
				String[] list = file.list();
				for (String string : list) {
					listFile(new File(string), files);
				}
			} else {
				files.add(file.getName());
			}
		}
	}
}
