package com.aaron.spring.aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib
 * 
 * @author Aaron
 * @date 2018年8月3日
 * @version 1.0
 * @package_type com.aaron.spring.aop.CglibAbsMethodAdvance
 */
public abstract class CglibAbsMethodAdvance implements MethodInterceptor {

	/**
	 * 要被代理的目标对象
	 */
	private Object targetObject;

	/**
	 * 被代理的方法名
	 */
	private String proxyMethodName;

	/**
	 * 给目标对象创建代理对象
	 */
	public Object getProxyInstance(Object targetObject) {
		Enhancer enhancer = new Enhancer();
		// 设置父类
		enhancer.setSuperclass(targetObject.getClass());
		// 设置回调函数
		enhancer.setCallback(this);
		// 创建子类(代理对象)
		return enhancer.create();

	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		Object result = null;
		String proxyMethod = getProxyMethodName();

		if (proxyMethod != null && proxyMethod.equals(method.getName())) {
			System.out.print(proxyMethod + "--------");
			doBefore();
		}

		// 执行拦截的方法
		result = proxy.invokeSuper(obj, args);

		if (proxyMethod != null && proxyMethod.equals(method.getName())) {
			doAfter();
		}
		return result;
	}

	public abstract void doBefore();

	public abstract void doAfter();

	public String getProxyMethodName() {
		return proxyMethodName;
	}

	public void setProxyMethodName(String proxyMethodName) {
		this.proxyMethodName = proxyMethodName;
	}
}
