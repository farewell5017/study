package com.cjt.study.service;

import com.cjt.study.domain.UserEntity;

public interface IUserService {
	public UserEntity findUserByName(String username);
}
