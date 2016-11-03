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

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;

/**
 * 测试ZipFile类的使用
 * 
 * @author 308655
 * @date 2016-8-19 下午4:20:17
 * @since
 * @version
 */
public class TestZipFile {
	public static void main(String[] args) throws Exception {
		File file = new File("d:" + File.separator + "hello.zip");
		createZipFile(file);
	}

	/**
	 * 创建zipFile
	 * 
	 * @author 308655
	 * @date 2016-8-19 下午4:21:17
	 * @param file
	 * @throws IOException
	 * @see
	 */
	public static void createZipFile(File file) throws IOException {
		@SuppressWarnings({ "unused", "resource" })
		ZipFile zipFile = new ZipFile(file);
	}
}
