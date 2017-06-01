package com.aaron.design.singleton;

/**
 * 单例模式--懒汉式 双检索机制 线程同步
 * 
 * @author Aaron
 * @date 2017年6月1日
 * @version 1.0
 * @package_name com.aaron.design.singleton
 */
public class SingletonDoubleCheck {
	private static SingletonDoubleCheck instance = null;
	private static volatile SingletonDoubleCheck instanceVolatile = null;

	private SingletonDoubleCheck() {
		System.out.println("懒汉式--双检索机制####构造方法私有化，提供公共静态方法被外部访问");
	}

	/**
	 * 双检索机制
	 * 
	 * @return
	 */
	public static SingletonDoubleCheck getInstance() {
		if (instance == null) {
			synchronized (SingletonDoubleCheck.class) {
				SingletonDoubleCheck temp = instance;
				if (temp == null) {
					temp = new SingletonDoubleCheck();
					instance = temp;
				}
			}
		}
		return instance;
	}

	public static SingletonDoubleCheck getInstanceByVolatile() {
		if (instanceVolatile == null) {
			synchronized (SingletonDoubleCheck.class) {
				if (instanceVolatile == null) {
					instanceVolatile = new SingletonDoubleCheck();
				}
			}
		}
		return instanceVolatile;
	}

}
