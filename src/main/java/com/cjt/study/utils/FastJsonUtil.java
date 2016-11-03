package com.cjt.study.utils;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 引入alibaba FastJson.<br>
 * 详情请移步 http://code.alibabatech.com/wiki/display/FastJSON/Overview 不要从工具类继承
 * 不要试图实例化工具类
 * 
 * @author lesia
 * @version V1.0
 * @Time 2013-5-9
 * @Modify remarks:
 */
public final class FastJsonUtil {

	/**
	 * 对象转Json字符串 漂亮的格式 <br>
	 * <font color="red">不同接口通信 不要调用此方法.会加入多余的换行,导致下游系统无法解析</font>
	 * 
	 * @author 269870
	 * @date 2016-3-8 下午5:17:17
	 * @param object
	 * @return
	 * @see
	 */
	public static final String toPrettyJSONString(Object object) {
		return JSON.toJSONString(object, SerializerFeature.PrettyFormat);
	}

	/**
	 * 对象转Json字符串
	 * 
	 * @author 269870
	 * @date 2016-3-8 下午5:17:35
	 * @param object
	 * @param features
	 * @return
	 * @see
	 */
	public static final String toJSONString(Object object, SerializerFeature... features) {
		return JSON.toJSONString(object, features);
	}

	/**
	 * 对象转Json字符串
	 * 
	 * @author lesia
	 * @Time 2013-5-9
	 * @param object
	 * @param dateFormat
	 * @param features
	 * @return
	 */
	public static final String toJSONStringWithDateFormat(Object object, String dateFormat,
			SerializerFeature... features) {
		return JSON.toJSONStringWithDateFormat(object, dateFormat, features);
	}

	/**
	 * Json 字符串 转对象
	 * 
	 * @author lesia
	 * @Time 2013-5-9
	 * @param text
	 * @param clazz
	 * @param features
	 * @return
	 */
	public static final <T> T parseObject(String text, Class<T> clazz, Feature... features) {
		return JSON.parseObject(text, clazz, features);
	}

	/**
	 * Json 字符串 转对象
	 * 
	 * @author lesia
	 * @Time 2013-5-9
	 * @param text
	 * @param clazz
	 * @param features
	 * @return
	 */
	public static final <T> List<T> parseList(String text, Class<T> clazz) {
		return JSON.parseArray(text, clazz);
	}

	private FastJsonUtil() {
	}
}
