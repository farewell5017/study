package com.cjt.study.basic.server.test.ognl;

public class OgnlUser {
	private Integer id;
	private String name;
	private OgnlDepartment department;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OgnlDepartment getDepartment() {
		return department;
	}

	public void setDepartment(OgnlDepartment department) {
		this.department = department;
	}

}
