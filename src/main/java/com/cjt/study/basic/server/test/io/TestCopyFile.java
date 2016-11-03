package com.cjt.study.basic.server.test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 308655
 * @date 2016-8-18 下午4:37:50
 * @since
 * @version
 */
public class TestCopyFile {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// 字节流
		InputStream in = new FileInputStream(new File("50.jpg"));
		File toFile = new File("D:\\51.jpg");
		FileOutputStream fos = new FileOutputStream(toFile, true);
		byte[] bArr = new byte[1];
		while (in.read(bArr) != -1) {
			fos.write(bArr[0]);
		}
		System.out.println("over...........");
	}
}
