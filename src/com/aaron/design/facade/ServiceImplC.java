package com.aaron.design.facade;

interface ServiceC{
	void methodC();
}
public class ServiceImplC implements ServiceC{

	@Override
	public void methodC() {
		System.out.println("####子系统C方法 methodC is start#####");
	}

}
