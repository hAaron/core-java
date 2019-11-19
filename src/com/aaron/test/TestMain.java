package com.aaron.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

		List<String> strings = Arrays.asList("6", "1", "3", "1", "2");
		Collections.sort(strings);// sort方法在这里
		for (String string : strings) {
			System.out.println(string);
		}

	}
}
