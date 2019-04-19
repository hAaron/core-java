package com.aaron.design.facade;

interface ServiceC {
	void methodC();
}

/**
 * 
 * @author Aaron
 * @date 2019年4月19日
 * @version 1.0
 * @package_type com.aaron.design.facade.ServiceImplC
 */
public class ServiceImplC implements ServiceC {

	@Override
	public void methodC() {
		System.out.println("####子系统C方法 methodC is start#####");
	}

}
