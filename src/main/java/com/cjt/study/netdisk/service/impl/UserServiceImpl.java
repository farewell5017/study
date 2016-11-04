package com.cjt.study.netdisk.service.impl;

import javax.annotation.Resource;

import com.cjt.study.netdisk.domain.UserEntity;
import com.cjt.study.netdisk.mapper.IUserMapper;
import com.cjt.study.netdisk.service.IUserService;

public class UserServiceImpl implements IUserService {
	@Resource
	private IUserMapper userDaoImpl;

	@Override
	public UserEntity findUserByName(String username) {
		UserEntity user = userDaoImpl.findUserByName(username);
		return user;
	}

	public IUserMapper getUserDaoImpl() {
		return userDaoImpl;
	}

	public void setUserDaoImpl(IUserMapper userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

}
