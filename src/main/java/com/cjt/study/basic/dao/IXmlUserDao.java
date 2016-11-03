package com.cjt.study.basic.dao;

import java.util.List;

import com.cjt.study.basic.domain.XmlUser;

public interface IXmlUserDao {
	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	void AddUser(XmlUser user);

	/**
	 * 删除用户
	 */
	void DeleteUser(XmlUser user);

	/**
	 * 根据用户名来查找用户
	 * 
	 * @param userName
	 * @return 查到到的用户
	 */
	List<XmlUser> find(String userName);

	List<XmlUser> queryAllUser();

	void alterUser(XmlUser user);
}
