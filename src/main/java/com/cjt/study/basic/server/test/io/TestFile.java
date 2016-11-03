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
import java.net.URL;

/**
 * @author 308655
 * @date 2016-8-18 下午3:15:19
 * @since
 * @version
 */
public class TestFile {
	public static void main(String[] args) throws IOException {
		// File file = new File("/");
		TestFile testFile = new TestFile();
		@SuppressWarnings("unused")
		URL resource = testFile.getClass().getClassLoader().getResource("");
		// testFile.listAllFiles(new File(resource.getPath()));
		File file = new File("D:\\test\\test\\ss.sh");
		file.createNewFile();
	}

	@SuppressWarnings("unused")
	private void listAllFiles(File f) {
		if (f.exists()) {
			if (f.isDirectory()) {
				File[] listFiles = f.listFiles();
				if (listFiles != null && listFiles.length > 0) {
					for (File file : listFiles) {
						listAllFiles(file);
					}
				}
			}
			System.out.println(f.toString());
		}
	}
}
