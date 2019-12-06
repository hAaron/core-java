package com.aaron.design.facade;

/**
 * 为了用户使用方便，把过度拆分的分散功能，组合成一个整体，对外提供一个统一的接口
 * 
 * 引入一个第三方中介类，这个类集合了多个零部件类的功能，实际功能则委托给这些零部件对象，这个类只是做为对外的统一接口，只是一个马甲； 引入中介对象<br>
 * 有许多细粒度的小对象<br>
 * 中介对象暴露了这些小对象的功能；<br>
 * 中介对象实际功能委托给这些小对象<br>
 * 中介对象提供给外部使用（对外隐藏那些小对象）<br>
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
