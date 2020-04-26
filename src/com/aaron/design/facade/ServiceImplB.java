package com.aaron.design.facade;

interface ServiceB {
	void methodB();
}

/**
 * 子系统角色
 * 
 * @author Aaron
 * @date 2019年4月19日
 * @version 1.0
 * @package_type com.aaron.design.facade.ServiceImplB
 */
public class ServiceImplB implements ServiceB {

	@Override
	public void methodB() {
		System.out.println("####子系统B方法 methodB is start#####");
	}

}
