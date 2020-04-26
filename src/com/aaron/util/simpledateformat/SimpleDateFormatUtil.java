package com.aaron.util.simpledateformat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat 多线程不安全，使用格式化日期方式，或者使用jodatime包
 * 
 * @author Aaron
 * @date 2019年6月17日
 * @version 1.0
 * @package_type com.aaron.util.simpledateformat.SimpleDateFormatUtil
 */
public class SimpleDateFormatUtil {
	public static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();

	public static void main(String[] args) {
		if (threadLocal.get() == null) {
			threadLocal.set(new SimpleDateFormat("yyyy-MM-dd"));
		}
		System.out.println(threadLocal.get().format(new Date()));

	}
}
