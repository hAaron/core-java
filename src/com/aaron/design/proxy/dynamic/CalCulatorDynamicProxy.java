package com.aaron.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 动态代理类 动态代理模式，核心主要是反射；主要使用到了：
 * 1、java.lang.reflect.InvocationHandler：InvocationHandler接口用来约束调用者实现；
 * 2、java.lang.reflect.Proxy：Proxy类主要用来获取动态代理对象，主要是重写的invoke方法；
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.proxy.dynamic
 */
public class CalCulatorDynamicProxy {

	// 被代理类的实例
	private Calculator calculator;

	// 将被代理者的实例传进动态代理类的构造函数中
	CalCulatorDynamicProxy(Calculator calculator) {
		this.calculator = calculator;
	}

	public Calculator getCalculator() {
		Calculator proxy = null;

		ClassLoader loader = calculator.getClass().getClassLoader();// 获取类加载器

		Class[] interfaces = new Class[] { Calculator.class };// 代理对象的类型

		InvocationHandler h = new InvocationHandler() {// 调用处理器

			// proxy:被代理对象
			// method:被调用的方法
			// args:方法调用时所需要的参数
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("---日志记录开始---");
				String name = method.getName();// 获取方法的名字
				System.out.println("方法" + name + "()开始执行了");
				System.out.println("方法中的参数是：" + Arrays.asList(args));
				Object result = method.invoke(calculator, args);
				System.out.println("方法执行后的结果是" + result);
				return result;
			}
		};
		/*
		 * Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces,
		 * InvocationHandler h) classLoader:被代理类的类加载器
		 * interfaces:被代理类已实现的所有接口，而这些是动态代理类要实现的接口列表
		 * invocationHandler:用被代理类的实例创建动态代理类的实例，用于真正调用处理程序 return
		 * ：返回实现了被代理类所实现的所有接口的Object对象，即动态代理，需要强制转型
		 */
		// 获得代理的实例
		proxy = (Calculator) Proxy.newProxyInstance(loader, interfaces, h);// 代理对象
		return proxy;
	}
}
