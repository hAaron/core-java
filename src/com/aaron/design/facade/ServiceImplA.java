package com.aaron.design.facade;

interface ServiceA {
	void methodA();
}

/**
 * 
 * @author Aaron
 * @date 2019年4月19日
 * @version 1.0
 * @package_type com.aaron.design.facade.ServiceImplA
 */
public class ServiceImplA implements ServiceA {

	@Override
	public void methodA() {
		System.out.println("####子系统A方法 methodA is start#####");
	}

}
