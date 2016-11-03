package com.cjt.study.basic.dao.impl;

import java.util.List;

import com.cjt.study.basic.dao.IXmlUserDao;
import com.cjt.study.basic.domain.XmlUser;
import com.cjt.study.utils.XmlUtils;

public class XmlUserDaoImpl implements IXmlUserDao {
	/**
	 * 添加用户
	 */
	@Override
	public void AddUser(XmlUser user) {
		XmlUtils.addUser(user);
	}

	/**
	 * 删除用户
	 */
	@Override
	public void DeleteUser(XmlUser user) {
		XmlUtils.deleteUser(user);
	}

	/**
	 * 根据用户名查询
	 */
	@Override
	public List<XmlUser> find(String userName) {
		return XmlUtils.queryByUserName(userName);
	}

	@Override
	public List<XmlUser> queryAllUser() {
		return XmlUtils.queryAllUser();
	}

	@Override
	public void alterUser(XmlUser user) {
		XmlUtils.alterUser(user);
	}

}
