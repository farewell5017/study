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
package com.cjt.study.basic.server.servlet;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 308655
 * @date 2016-8-5 上午9:36:51
 * @since
 * @version
 */
public class SendHttpRequest {
	/**
	 * 发送GET请求
	 * 
	 * @author 308655
	 * @date 2016-8-5 上午9:38:11
	 * @param url
	 * @param param
	 * @return
	 * @throws Exception
	 * @see
	 */
	public static String sendGet(String url, String param) throws Exception {
		String urlWithParameter = url + "?" + param;
		System.out.println("最终请求url:" + urlWithParameter);
		URL realUrl = new URL(urlWithParameter);
		URLConnection connection = realUrl.openConnection();
		connection.setRequestProperty("accept", "*/*");
		connection.setRequestProperty("connection", "Keep-Alive");
		connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		connection.connect();
		Map<String, List<String>> headerFields = connection.getHeaderFields();
		if (null != headerFields) {
			Set<String> keySet = headerFields.keySet();
			for (String s : keySet) {
				System.out.println(s + " : " + headerFields.get(s));
			}
		}

		InputStream inputStream = connection.getInputStream();
		StringBuffer out = new StringBuffer();
		byte[] b = new byte[4096];
		for (int n; (n = inputStream.read(b)) != -1;) {
			out.append(new String(b, 0, n));
		}
		return out.toString();

	}

	public static String sendPost() {
		return null;

	}

	public static void main(String[] args) throws Exception {
		String url = "http://10.224.71.14:8882/test/server/testPush";
		String result = sendGet(url, "companyCode=EWBKLP");
		System.out.println(result);
	}

}
