package com.aaron.spring.tx;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * 
 * @author Aaron
 * @date 2018年8月20日
 * @version 1.0
 * @package_type com.spring.tx.TxProxyManager
 */
public class TxProxyManager implements InvocationHandler {

	private Object target;

	/**
	 * 获取代理对象
	 * @param target
	 * @return
	 */
	public Object getProxy(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	/**
	 * 通过TxProxyManager创建出来的代理对象在调用自己的方法时， 会通过invoke这个方法进行调用，而不是直接调用
	 * 
	 * @param proxy
	 *            被代理对象
	 * @param method
	 *            被代理对象执行的方法
	 * @param args
	 *            被代理对象执行的方法所需要的参数
	 *
	 */
	@SuppressWarnings("finally")
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) {
		System.out.println("动态代理对象,准备进入事务..");
		Object result = null;
		try {
			// 执行被代理对象自己的方法
			result = method.invoke(target, args);
			System.out.println(1 / 0);//手动抛出异常
			// 如果没错，执行数据库的commit方法
			System.out.println("执行commit");
		} catch (Exception e) {
			// 如果有错误，执行数据库的rollBack方法
			System.out.println("执行rollBack");
		} finally {
			return result;
		}
	}

}
