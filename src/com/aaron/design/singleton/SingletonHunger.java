package com.aaron.design.singleton;

/**
 * 饿汉式 “空间换时间”，开始就创建实例，每次用到的之后直接返回. 缺点：没有达到lazy loading的效果
 * 
 * @author Aaron
 * @date 2017年6月1日
 * @version 1.0
 * @package_name com.aaron.design.singleton
 */
public class SingletonHunger {

	private static SingletonHunger instance = new SingletonHunger();

	private SingletonHunger() {
		System.out.println("饿汉式####构造方法私有化，提供公共静态方法被外部访问");
	}

	public static SingletonHunger getInstance() {
		return instance;
	}

}
