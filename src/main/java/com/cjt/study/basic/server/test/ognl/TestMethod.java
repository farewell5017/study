package com.cjt.study.basic.server.test.ognl;

public class TestMethod {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void print(String name) {
		System.out.println(name);
	}

	public static void staticMethod() {

		System.out.println("我是静态方法!");
	}
}
