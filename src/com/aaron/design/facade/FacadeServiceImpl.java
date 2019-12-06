package com.aaron.design.facade;

/**
 * 门面角色：对外提供统一方法
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.facade
 */
public class FacadeServiceImpl {

	ServiceImplA serviceImplA;
	ServiceImplB serviceImplB;
	ServiceImplC serviceImplC;

	public FacadeServiceImpl() {
		serviceImplA = new ServiceImplA();
		serviceImplB = new ServiceImplB();
		serviceImplC = new ServiceImplC();
	}

	public void methodA() {
		serviceImplA.methodA();
	}

	public void methodB() {
		serviceImplB.methodB();
	}

	public void methodC() {
		serviceImplC.methodC();
	}

}
