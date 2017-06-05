package com.aaron.design.facade;

/**
 * 在于降低系统的复杂程度。从很大程度上提高了客户端使用的便捷性， 
 * 使得客户端无须关心子系统的工作细节，通过外观角色即可调用相关功能。
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.facade
 */
public class TestFacade {
	public static void main(String[] args) {
		FacadeServiceImpl facadeServiceImpl = new FacadeServiceImpl();
		facadeServiceImpl.methodA();
		facadeServiceImpl.methodB();
		facadeServiceImpl.methodC();
	}
}
