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
package com.cjt.study.basic.server.test;

import java.text.SimpleDateFormat;

/**
 * @author 308655
 * @date 2016-8-15 上午10:10:41
 * @since
 * @version
 */
public class TestRunnable implements Runnable {
	private final String name;

	/**
	 * @author 308655
	 * @date 2016-8-15 上午10:11:13
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		for (int i = 0; i < 5; i++) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒SSSS毫秒");
			System.out.println(name + "运行" + i + "  :  " + sdf.format(System.currentTimeMillis()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @author 308655
	 * @date 2016-8-15 上午10:14:03
	 * @param name
	 */
	public TestRunnable(String name) {
		super();
		this.name = name;
	}

}
