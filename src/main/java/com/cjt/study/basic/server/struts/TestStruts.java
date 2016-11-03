package com.cjt.study.basic.server.struts;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.DefaultActionSupport;

import com.cjt.study.basic.domain.XmlUser;
import com.cjt.study.utils.XmlUtils;
import com.opensymphony.xwork2.ActionContext;

public class TestStruts extends DefaultActionSupport {
	private static final long serialVersionUID = -5606727272057444990L;
	private String message;
	private XmlUser loginUser;

	@Override
	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		if (StringUtils.isBlank(loginUser.getUserName())) {
			message = "用户名不能为空!";
			actionContext.put("message", message);
			return LOGIN;
		}
		if (StringUtils.isBlank(loginUser.getUserPwd())) {
			message = "密码不能为空!";
			actionContext.put("username", loginUser.getUserName());
			actionContext.put("message", message);
			return LOGIN;
		}
		List<XmlUser> list = XmlUtils.queryByUserName(loginUser.getUserName());
		if (list == null || list.size() == 0) {
			message = "用户不存在!";
		} else if (!loginUser.getUserPwd().equals(list.get(0).getUserPwd())) {
			actionContext.put("username", loginUser.getUserName());
			message = "密码错误!";
		} else {
			actionContext.getSession().put("loginUser", list.get(0));
			Cookie[] cookies = ServletActionContext.getRequest().getCookies();
			if (cookies.length > 0) {
				for (Cookie cookie : cookies) {
					if ("lastTime".equals(cookie.getName())) {
						actionContext.getSession().put("lastTime", URLDecoder.decode(cookie.getValue(), "utf-8"));
						break;
					}
				}
			}
			actionContext.put("lastTime", "第一次访问!");
			@SuppressWarnings("deprecation")
			Cookie cookie1 = new Cookie("lastTime",
					URLEncoder.encode("上次访问时间:" + new Date().toLocaleString(), "utf-8"));
			ServletActionContext.getResponse().addCookie(cookie1);
			return "success";
		}
		actionContext.put("message", message);
		return LOGIN;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public XmlUser getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(XmlUser loginUser) {
		this.loginUser = loginUser;
	}

}
