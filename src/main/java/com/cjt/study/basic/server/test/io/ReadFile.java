package com.cjt.study.basic.server.test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;

/**
 * @author 308655
 * @date 2016-8-19 上午8:46:22
 * @since
 * @version
 */
public class ReadFile {
	public static void main(String[] args) throws Exception {
		File file = new File("readFile.txt");
		// readFileFull(file);
		// readFileByByte(file);
		// readFileByCharacter(file);
		// testFileReader(file);
		testReadFileByLine(file);
	}

	/**
	 * 整个读取文件 按字节
	 * 
	 * @author 308655
	 * @date 2016-8-19 上午9:37:06
	 * @param file
	 * @throws IOException
	 * @see
	 */
	public static void readFileFull(File file) throws IOException {
		if (file.exists() && file.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] bArr = new byte[(int) file.length()];
			fileInputStream.read(bArr);
			fileInputStream.close();
			System.out.println(new String(bArr));
		} else {
			throw new IllegalArgumentException("参数不合法！");
		}
	}

	/**
	 * 逐字节读取文件
	 * 
	 * @throws Exception
	 */
	public static void readFileByByte(File file) throws Exception {
		if (file.exists() && file.isFile()) {
			@SuppressWarnings("resource")
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] bArr = new byte[(int) file.length()];
			int temp = 0;
			int count = 0;
			while ((temp = fileInputStream.read()) != -1) {
				bArr[count++] = (byte) temp;
			}
			System.out.println(new String(bArr));
		} else {
			throw new IllegalArgumentException("参数不合法！");
		}
	}

	/**
	 * 字符流讀取文件
	 * 
	 * @author 308655
	 * @date 2016-8-19 上午10:08:19
	 * @param file
	 * @throws IOException
	 * @see
	 */
	public static void readFileByCharacter(File file) throws IOException {
		if (file.exists() && file.isFile()) {
			@SuppressWarnings("resource")
			InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
			int temp = 0;
			StringBuffer sb = new StringBuffer();
			while ((temp = inputStreamReader.read()) != -1) {
				sb.append((char) temp);
			}
			System.out.println(sb.toString());
		} else {
			throw new IllegalArgumentException("参数不合法！");
		}
	}

	/**
	 * FileReader
	 * 
	 * @author 308655
	 * @date 2016-8-19 上午10:23:10
	 * @param file
	 * @throws Exception
	 * @see
	 */
	public static void testFileReader(File file) throws Exception {
		FileReader fileReader = new FileReader(file);
		StringBuffer sb = new StringBuffer();
		int i = 0;
		while ((i = fileReader.read()) != -1) {
			sb.append((char) i);
		}
		fileReader.close();
		System.out.println(sb.toString());
		System.out.println("testFileReader");
	}

	/**
	 * 逐行读取文件
	 * 
	 * @author 308655
	 * @date 2016-8-19 下午2:39:13
	 * @param file
	 * @throws IOException
	 * @see
	 */
	public static void testReadFileByLine(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String temp = "";
		int count = 0;
		while ((temp = bufferedReader.readLine()) != null) {
			System.out.println(MessageFormat.format("第{0}行:{1}", count++, temp));
		}
		bufferedReader.close();
	}
}
