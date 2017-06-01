package com.aaron.design.singleton;

/**
 * 懒汉式--静态内部类 优点：加载时不会初始化静态变量INSTANCE，因为没有主动使用，达到Lazy loadin
 * 
 * @author Aaron
 * @date 2017年6月1日
 * @version 1.0
 * @package_name com.aaron.design.singleton
 */
public class SingletonInnerClass {

	private SingletonInnerClass() {
		System.out.println("懒汉式--静态内部类####构造方法私有化，提供公共静态方法被外部访问");
	}

	private static class InnerSingleton {
		private final static SingletonInnerClass instance = new SingletonInnerClass();
	}
	
	public static SingletonInnerClass getInstance(){
		return InnerSingleton.instance;
	}

}
