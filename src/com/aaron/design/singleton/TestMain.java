package com.aaron.design.singleton;

/**
 * 测试类
 * 
 * @author Aaron
 * @date 2017年6月1日
 * @version 1.0
 * @package_name com.aaron.design.singleton
 */
public class TestMain {

	public static void main(String[] args) {
		// 饿汉式
		// SingletonHunger singletonHunger=SingletonHunger.getInstance();
		// System.out.println(singletonHunger);

		// 懒汉式--静态内部类
		// SingletonInnerClass singletonInnerClass =
		// SingletonInnerClass.getInstance();
		// System.out.println(singletonInnerClass);

		// 懒汉式--双检索
		// SingletonDoubleCheck singletonDoubleCheck =
		// SingletonDoubleCheck.getInstance();
		// SingletonDoubleCheck singletonDoubleCheck2 =
		// SingletonDoubleCheck.getInstanceByVolatile();
		// System.out.println(singletonDoubleCheck);
		// System.out.println(singletonDoubleCheck2);

		// 懒汉式--枚举
		System.out.println(SingletonEnum.INSTANCE);
	}

}
