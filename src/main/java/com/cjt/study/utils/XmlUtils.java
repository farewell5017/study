package com.cjt.study.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.cjt.study.basic.domain.XmlUser;

public class XmlUtils  implements Serializable{
	private static final long serialVersionUID = -4504846132034707309L;
	private static Logger LOG = Logger.getLogger(XmlUtils.class);
	private static Element rootEle;
	private static Document document;
	private static File file;
	static {
		SAXReader reader = new SAXReader();
		// URL resource = ClassLoader.getSystemResource("D:\\db.xml");
		file = new File("D:\\db.xml");
		if (null == file || !file.isFile()) {
			throw new IllegalArgumentException("xml文件不存在!");
		}
		try {
			document = reader.read(file);
			rootEle = document.getRootElement();
		} catch (DocumentException e) {
			LOG.error(e.getMessage());
			throw new IllegalArgumentException("文件格式不正确!");
		}
	}

	/**
	 * query all users
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static List<XmlUser> queryAllUser() {
		List<XmlUser> userLst = new ArrayList<XmlUser>();
		for (Iterator<Element> it = rootEle.elementIterator(); it.hasNext();) {
			Element userEle = it.next();
			XmlUser userVo = new XmlUser();
			userVo.setId(userEle.element("id") == null ? "" : userEle.element("id").getTextTrim());
			userVo.setBirthday(userEle.element("birthday") == null ? "" : userEle.element("birthday").getTextTrim());
			userVo.setEmail(userEle.element("email") == null ? "" : userEle.element("email").getTextTrim());
			userVo.setUserName(userEle.element("userName") == null ? "" : userEle.element("userName").getTextTrim());
			userVo.setUserPwd(userEle.element("userPwd") == null ? "" : userEle.element("userPwd").getTextTrim());
			userLst.add(userVo);
			// System.out.println(userVo.toString());
		}
		return userLst;
	}

	/**
	 * add user
	 * 
	 * @param user
	 *            2016年10月25日 上午10:01:42 $
	 */
	public static void addUser(XmlUser user) {
		if (null == user || user.getId() != null || user.getUserName() == null) {
			throw new IllegalArgumentException("请检查所有必填项!id不填!");
		}
		// 前置处理!
		List<XmlUser> users = queryAllUser();
		int maxId = 0;
		if (users != null && users.size() > 0) {
			for (XmlUser u : users) {
				if (u.getId() != null) {
					maxId = Integer.parseInt(u.getId()) > maxId ? Integer.parseInt(u.getId()) : maxId;
				}
				if (u.getUserName() != null && u.getUserName().equals(user.getUserName())) {
					throw new IllegalArgumentException("用户已存在!");
				}
			}
		}
		// 执行添加
		Element userEle = rootEle.addElement("user");
		Element idEle = userEle.addElement("id");
		idEle.setText(++maxId + "");
		Element userNameEle = userEle.addElement("userName");
		userNameEle.setText(user.getUserName());
		Element userPwdEle = userEle.addElement("userPwd");
		userPwdEle.setText(user.getUserPwd());
		Element emailEle = userEle.addElement("email");
		emailEle.setText(user.getEmail());
		Element birthdayEle = userEle.addElement("birthday");
		birthdayEle.setText(user.getBirthday());
		write(document, file);
	}

	/**
	 * 根据用户名查询
	 * 
	 * @param userName
	 * @return 2016年10月25日 上午11:04:43 $
	 */
	public static List<XmlUser> queryByUserName(String userName) {
		List<XmlUser> userLst = new ArrayList<XmlUser>();
		if (StringUtils.isBlank(userName)) {
			return userLst;
		}
		// 前置处理!
		List<XmlUser> users = queryAllUser();
		if (null != users && users.size() > 0) {
			for (XmlUser user : users) {
				if (user != null && user.getUserName() != null && user.getUserName().equals(userName)) {
					userLst.add(user);
				}
			}
		}

		return userLst;
	}

	/**
	 * 删除用户
	 * 
	 * @param user
	 *            2016年10月25日 上午11:02:24 $
	 */
	@SuppressWarnings("unchecked")
	public static void deleteUser(XmlUser user) {
		if (null == user || StringUtils.isBlank(user.getUserName())) {
			throw new IllegalArgumentException("用户不存在!");
		}
		for (Iterator<Element> it = rootEle.elementIterator(); it.hasNext();) {
			Element userEle = it.next();
			if (userEle.element("userName") != null
					&& user.getUserName().equals(userEle.element("userName").getText())) {
				userEle.remove(userEle.element("userName"));
				if (null != userEle.element("id")) {
					userEle.remove(userEle.element("id"));
				}
				if (null != userEle.element("userPwd")) {
					userEle.remove(userEle.element("userPwd"));
				}
				if (null != userEle.element("email")) {
					userEle.remove(userEle.element("email"));
				}
				if (null != userEle.element("birthday")) {
					userEle.remove(userEle.element("birthday"));
				}
			}
			rootEle.remove(userEle);
		}
		write(document, file);
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 *            2016年10月25日 上午11:27:39 $
	 */
	@SuppressWarnings("unchecked")
	public static void alterUser(XmlUser user) {
		if (null == user || user.getId() == null) {
			throw new IllegalArgumentException("id必填!");
		}
		for (Iterator<Element> it = rootEle.elementIterator(); it.hasNext();) {
			Element userEle = it.next();
			if (userEle.element("id") != null && user.getId().equals(userEle.element("id").getText())) {
				if (null != userEle.element("userPwd")) {
					userEle.element("userPwd").setText(user.getUserPwd());
				} else {
					userEle.addElement("userPwd").setText(user.getUserPwd());
				}
				if (null != userEle.element("userName")) {
					userEle.element("userName").setText(user.getUserName());
				} else {
					userEle.addElement("userName").setText(user.getUserName());
				}
				if (null != userEle.element("email")) {
					userEle.element("email").setText(user.getEmail());
				} else {
					userEle.addElement("email").setText(user.getEmail());
				}
				if (null != userEle.element("birthday")) {
					userEle.element("birthday").setText(user.getBirthday());
				} else {
					userEle.addElement("birthday").setText(user.getEmail());
				}
			}
		}
		write(document, file);
	}

	/**
	 * 保存文件
	 * 
	 * 2016年10月25日 上午11:26:17 $
	 */
	public static void write(Document document, File file) {
		// 美化格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		try {
			XMLWriter xmlWriter = new XMLWriter(new FileWriter(file), format);
			xmlWriter.write(document);
			xmlWriter.flush();
			xmlWriter.close();
		} catch (IOException e) {
			LOG.error("保存到文件失败:" + e.getMessage());
			throw new RuntimeException("保存到文件失败:" + e.getMessage());
		}
	}
}
