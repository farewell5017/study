package com.cjt.study.web;

import com.cjt.study.domain.UserEntity;
import com.cjt.study.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = -7145739727330700L;
	private IUserService userService;
	private String username;
	private String password;
	private String message;
	private UserEntity user;

	@Override
	public String execute() throws Exception {
		user = userService.findUserByName(username);
		return SUCCESS;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
