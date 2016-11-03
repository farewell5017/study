package com.cjt.study.basic.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjt.study.utils.FastJsonUtil;

/**
 * @author 308655
 * @date 2016-8-17 上午10:49:30
 * @since
 * @version
 */
public class TestReqRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 请求重定向
	 * 
	 * @author 308655
	 * @date 2016-8-17 上午10:50:14
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// String servletPath = req.getContextPath();
		// resp.sendRedirect(servletPath + "/index.jsp?a=1");
		PrintWriter out = resp.getWriter();
		out.print(FastJsonUtil.toPrettyJSONString("2213231231"));
		out.flush();
		out.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
