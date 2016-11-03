package com.cjt.study.basic.domain;

/**
 * 
 * @author 308655
 * @date 2016-8-3        下午12:28:59
 * @since
 * @version
 */
public class RequestVo {
	private String companyCode;
	private String timestamp;
	private String digest;
	private String params;

	/**
	 * @return the companyCode
	 */
	public String getCompanyCode() {
		return companyCode;
	}

	/**
	 * @param companyCode
	 *            the companyCode to set
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the digest
	 */
	public String getDigest() {
		return digest;
	}

	/**
	 * @param digest
	 *            the digest to set
	 */
	public void setDigest(String digest) {
		this.digest = digest;
	}

	/**
	 * @return the params
	 */
	public String getParams() {
		return params;
	}

	/**
	 * @param params
	 *            the params to set
	 */
	public void setParams(String params) {
		this.params = params;
	}

	/**
	 * @author 308655
	 * @date 2016-8-3 下午12:30:33
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RequestVo [companyCode=" + companyCode + ", timestamp=" + timestamp + ", digest=" + digest + ", params="
				+ params + "]";
	}

}
