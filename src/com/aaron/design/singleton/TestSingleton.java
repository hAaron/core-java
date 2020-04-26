package com.aaron.design.singleton;

/**
 * 单例模式 </br> 所谓单例就是所有的请求都用一个对象来处理，比如我们常用的service和dao层的对象通常都是单例的，</br>
 * 而多例则指每个请求用一个新的对象来处理，比如action;
 * 
 * @author Aaron
 * @date 2017年6月1日
 * @version 1.0
 * @package_name com.aaron.design.singleton
 */
public class TestSingleton {

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
		System.out.println(SingletonEnum.INSTANCE.getInstance());
	}

}
