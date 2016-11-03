package com.cjt.study.basic.domain;

import java.io.Serializable;

public class XmlUser implements Serializable {
	private static final long serialVersionUID = -2802277999512870365L;
	// 用户ID
	private String id;
	// 用户名
	private String userName;
	// 用户密码
	private String userPwd;
	// 用户邮箱
	private String email;
	// 用户生日
	private String birthday;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPwd=" + userPwd + ", email=" + email + ", birthday="
				+ birthday + "]";
	}

}
