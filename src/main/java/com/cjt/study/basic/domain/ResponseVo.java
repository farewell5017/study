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

/**
 * 
 * @author 308655
 * @date 2016-8-3 下 午12:51:31
 * @since
 * @version
 */
public class ResponseVo {
	private String result;
	private String resulCode;
	private String reason;

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the resulCode
	 */
	public String getResulCode() {
		return resulCode;
	}

	/**
	 * @param resulCode
	 *            the resulCode to set
	 */
	public void setResulCode(String resulCode) {
		this.resulCode = resulCode;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason
	 *            the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * <p>
	 * </p>
	 * 
	 * @author 308655
	 * @date 2016-8-3 下午12:52:09
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResponseVo [result=" + result + ", resulCode=" + resulCode + ", reason=" + reason + "]";
	}
}
