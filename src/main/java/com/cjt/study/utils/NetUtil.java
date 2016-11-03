package com.cjt.study.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * 网络工具类
 * 
 * @author lesia
 * 
 */
public final class NetUtil {
	/**
	 * 获取本地ip
	 * 
	 * @Title: getLocalIp
	 * @param @return
	 * @param @throws
	 *            Exception 设定文件
	 * @return String 返回类型
	 * @throws IOException
	 * @throws @author
	 *             zhangjiayi
	 * @date 2016-5-4 上午10:01:20
	 */
	public static String getLocalIp() {
		String hostIp = "";
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					InetAddress inetAddress = enumIpAddr.nextElement();
					if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress()
							&& inetAddress.isSiteLocalAddress()) {
						hostIp = inetAddress.getHostAddress().toString();
					}

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return hostIp;

	}
}
