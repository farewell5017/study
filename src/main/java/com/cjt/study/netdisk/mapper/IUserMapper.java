package com.cjt.study.netdisk.mapper;

import com.cjt.study.netdisk.domain.UserEntity;
import com.cjt.study.utils.MybatisAnotation;

/**
 * 
 * @author 308655
 * 
 *         2016年11月2日 下午5:20:43
 */
@MybatisAnotation
public interface IUserMapper {
	public UserEntity findUserByName(String username);
}
