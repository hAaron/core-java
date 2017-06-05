package com.aaron.design.facade;

interface ServiceB{
	void methodB();
}
public class ServiceImplB implements ServiceB{

	@Override
	public void methodB() {
		System.out.println("####子系统B方法 methodB is start#####");
	}

}
