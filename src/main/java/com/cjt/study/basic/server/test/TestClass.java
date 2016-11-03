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

/**
 * @author 308655
 * @date 2016-8-15 上午10:16:36
 * @since
 * @version
 */
public class TestClass {
	public static void main(String[] args) {
		// TestRunnable testRunnable1 = new TestRunnable("线程A");
		// TestRunnable testRunnable2 = new TestRunnable("线程B");
		// TestRunnable testRunnable3 = new TestRunnable("线程C");
		// TestRunnable testRunnable4 = new TestRunnable("线程D");
		// new Thread(testRunnable1).start();
		// new Thread(testRunnable2).start();
		// new Thread(testRunnable3).start();
		// new Thread(testRunnable4).start();
		TestThread testRunnable1 = new TestThread("线程A");
		TestThread testRunnable2 = new TestThread("线程B");
		TestThread testRunnable3 = new TestThread("线程C");
		TestThread testRunnable4 = new TestThread("线程D");
		testRunnable1.start();
		testRunnable2.start();
		testRunnable3.start();
		testRunnable4.start();
	}

}
