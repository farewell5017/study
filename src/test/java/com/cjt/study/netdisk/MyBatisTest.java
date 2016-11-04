package com.cjt.study.netdisk;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cjt.study.netdisk.domain.UserEntity;
import com.cjt.study.netdisk.service.impl.UserServiceImpl;

public class MyBatisTest {
	@SuppressWarnings("resource")
	@Test
	public void testCase() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		UserServiceImpl userService = (UserServiceImpl) ac.getBean("userService");
		UserEntity user = userService.findUserByName("cuijiateng@qq.com");
		System.out.println(user.toString());
	}

}
