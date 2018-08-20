package com.aaron.test;

import java.lang.reflect.Field;

/**
 * 主测试入口
 * 
 * @author Aaron
 * @date 2018年3月26日
 * @version 1.0
 * @package_type com.aaron.test.TestMain
 */
public class TestMain {
	public static void main(String[] args) {

		// User = new User();
		try {
			Class<?> cls = Class.forName("com.aaron.spring.ioc.User");
			String fieldName = "age";
			Field field = cls.getDeclaredField(fieldName);
			Object object = cls.newInstance();
			field.setAccessible(true);
			//需要判断字段类型（字符串和数字）
			field.set(object, 11);
			System.out.println(field.getType().getName());
			System.out.println(object.toString());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}