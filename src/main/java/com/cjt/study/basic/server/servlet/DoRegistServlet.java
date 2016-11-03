package com.cjt.study.basic.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class DoRegistServlet extends HttpServlet {

	private static final long serialVersionUID = -7573424371362787114L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String serverToken = (String) req.getSession().getAttribute("token");
		String clientToken = req.getParameter("token");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><body>");
		if (StringUtils.isNotBlank(clientToken) && clientToken.equals(serverToken)) {
			String[] parameterValues = req.getParameterValues("interest");
			String interest = "";
			if (parameterValues != null) {
				for (String string : parameterValues) {
					interest = interest + string + ";";
				}
			}
			req.getSession().setAttribute("token", System.currentTimeMillis() + "");

			writer.println("username:" + req.getParameter("username") + "<br>");
			writer.println("password:" + req.getParameter("password") + "<br>");
			writer.println("repassword:" + req.getParameter("repassword") + "<br>");
			writer.println("dept:" + req.getParameter("dept") + "<br>");
			writer.print("interest:" + interest + "<br>");
			writer.print("<h1>" + "remark:" + req.getParameter("remark") + "</h1><br>");
		} else {
			writer.println("表单重复提交!<br>");
		}

		writer.println(
				"<div align=\"left\"><input type=\"button\" value=\"关闭\" onclick=\"javascript:window.close()\"></div>");
		writer.println("</body></html>");
		writer.flush();
		writer.close();
	}

}
