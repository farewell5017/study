/*
 * Copyright by Deppon and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about Deppon from
 *
 *      http://www.deppon.com
 *
 */
package com.cjt.study.basic.domain;

public class CompanyEntity {
	/**
	 * 接入 商ID
	 */
	private int id;
	/**
	 * 接入商名称
	 */
	private String companyName;
	/**
	 * 接入商编码
	 */
	private String companyCode;
	/**
	 * 是否开通启用
	 */
	private String active;
	/**
	 * 特性，可通过K:V扩展
	 */
	private String features;
	private String appkey;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	@Override
	public String toString() {
		return "CompanyEntity [id=" + id + ", companyName=" + companyName + ", companyCode=" + companyCode + ", active="
				+ active + ", features=" + features + ", appkey=" + appkey + "]";
	}

}
