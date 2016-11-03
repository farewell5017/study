package com.cjt.study.basic.server.test.ognl;

import java.util.HashMap;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;

/**
 * OGNL表达式三要素:where,who,what
 * 
 * @author 308655 cjt
 * @date 2016年10月13日 下午2:28:31
 */
public class OgnlTestCase {
	// @Test
	public void testGetValue() throws Exception {
		OgnlUser user = new OgnlUser();
		user.setId(1);
		user.setName("downpour");
		// Create context
		Map<String, String> context = new HashMap<String, String>();
		context.put("introduction", "My name is ");
		// Test to directly get value from root object, with no context
		Object name = Ognl.getValue(Ognl.parseExpression("name"), user);
		System.out.println(name);
		Object contextValue = Ognl.getValue(Ognl.parseExpression("#introduction"), context, new Object());
		System.out.println(contextValue);
	}

	// @Test
	public void testCase1() throws OgnlException {
		// 上下文
		Map<String, Object> context = new HashMap<String, Object>();
		OgnlUser user1 = new OgnlUser();
		OgnlUser user2 = new OgnlUser();
		OgnlUser user3 = new OgnlUser();
		user1.setName("张三");
		user2.setName("李四");
		user3.setName("王五");
		// 放入上下文
		context.put("user1", user1);
		context.put("user2", user2);
		context.put("user3", user3);
		// 取值
		Object value1 = Ognl.getValue(Ognl.parseExpression("name"), user1);
		System.out.println(value1);
		Object value2 = Ognl.getValue("#user2.name", context, user2);
		System.out.println(value2);
		Object value3 = Ognl.getValue("name", context, user3);
		System.out.println(value3);
		Object value4 = Ognl.getValue("#user1.name", context, user3);
		System.out.println(value4);
	}

}
