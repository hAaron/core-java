package com.aaron.design.proxy.cglib;

/**
 * cglib代理：JDK的动态代理机制只能代理实现了接口的类，而不能实现接口的类就不能实现JDK的动态代理，cglib是针对类来实现代理的
 * 
 * 在Spring的AOP编程中: 如果加入容器的目标对象有实现接口，用JDK代理；如果目标对象没有实现接口,用Cglib代理
 * 
 * @author Aaron
 * @date 2018年3月24日
 * @version 1.0
 * @package_type com.aaron.design.proxy.cglib.TestClient
 */
public class TestClient {

	public static void main(String[] args) {
		UserDaoImpl target = new UserDaoImpl();
		UserDaoImpl proxy = (UserDaoImpl) new CglibProxy(target).getProxyInstance();
		proxy.addUser();
	}

}
