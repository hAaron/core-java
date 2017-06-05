package com.aaron.design.facade;

interface ServiceA{
	void methodA();
}
public class ServiceImplA implements ServiceA{

	@Override
	public void methodA() {
		System.out.println("####子系统A方法 methodA is start#####");
	}

}
