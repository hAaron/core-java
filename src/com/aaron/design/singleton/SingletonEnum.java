package com.aaron.design.singleton;

/**
 * 懒汉式 --推广
 * 
 * @author Aaron
 * @date 2017年6月1日
 * @version 1.0
 * @package_name com.aaron.design.singleton
 */
// public class SingletonEnum {
//
// private SingletonEnum() {
// System.out.println("懒汉式--静态内部类####构造方法私有化，提供公共静态方法被外部访问");
// }
//
//
//
// }

public enum SingletonEnum {
	INSTANCE;
}
