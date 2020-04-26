package com.aaron.util.jdk81;

/**
 * 测试jdk1.8 需要导入jdk1.8 jar包
 * 
 * @author Aaron
 * @date 2018年7月28日
 * @version 1.0
 * @package_type com.aaron.util.jdk81.Jdk8Test
 */

public class Jdk8Test {
	public static void main(String[] args) {
		// Prior Java 8 :
		// List features = Arrays.asList("Lambdas", "Default Method",
		// "Stream API", "Date and Time API");
		// for (String feature : features) {
		// System.out.println(feature);
		// }

		// In Java 8:
		// List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream
		// API", "Date and Time API");
		// features.forEach(n -> System.out.println(n));

		// Even better use Method reference feature of Java 8
		// method reference is denoted by :: (double colon) operator
		// looks similar to score resolution operator of C++
		// System.out.println("0000000000000000000");
		// features.forEach(System.out::println);
	}
}
