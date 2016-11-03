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
package com.cjt.study.basic.server.test.io;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;

/**
 * @author 308655
 * @date 2016-8-19 下午1:54:31
 * @since
 * @version
 */
public class WriteFile {
	public static void main(String[] args) throws Exception {
		File file = new File("writeFile.txt");
		String content = "I'm cuijiateng";
		writeString2File(content, file);
	}

	/**
	 * 将字符串输出到文本
	 * 
	 * @author 308655
	 * @date 2016-8-19 下午2:21:14
	 * @param content
	 * @throws Exception
	 * @see
	 */
	public static void writeString2File(String content, File file) throws Exception {
		FileOutputStream fileOutputStream = new FileOutputStream(file, true);
		byte[] bytes = (content + "\r\n").getBytes();
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		char[] cArr = new char[content.getBytes().length * 2];
		int temp = 0;
		int count = 0;
		while ((temp = byteArrayInputStream.read()) != -1) {
			cArr[count] = Character.toUpperCase((char) temp);
			count++;
		}
		System.out.println(MessageFormat.format("总共{0}个字符", count));
		fileOutputStream.write((new String(cArr) + "\r\n").getBytes());
		fileOutputStream.close();
		System.out.println(SimpleDateFormat.getTimeInstance().format(System.currentTimeMillis()));
	}
}
