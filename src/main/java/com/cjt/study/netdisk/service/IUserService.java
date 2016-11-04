package com.cjt.study.netdisk.service;

import com.cjt.study.netdisk.domain.UserEntity;

public interface IUserService {
	public UserEntity findUserByName(String username);
}
