package com.aaron.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 主测试入口
 * 
 * @author Aaron
 * @date 2018年3月26日
 * @version 1.0
 * @package_type com.aaron.test.TestMain
 */
public class TestMain {
	public static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();
	public static void main(String[] args) {
		if(threadLocal.get() == null) {
			threadLocal.set(new SimpleDateFormat("yyyy-MM-dd"));
		}
		System.out.println(threadLocal.get().format(new Date()));

	}

}