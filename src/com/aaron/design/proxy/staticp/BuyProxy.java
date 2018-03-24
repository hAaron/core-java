package com.aaron.design.proxy.staticp;

/**
 * 代理对象购买车票，代理类(持有对象的引用)
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.proxy.staticp
 */
public class BuyProxy implements TicketsSubject {

	private TicketsSubject ticketsSubject;

	public BuyProxy(TicketsSubject ticketsSubject) {
		this.ticketsSubject = ticketsSubject;
	}

	@Override
	public void buy() {
		getAuthority();
		System.out.println("####代理对象买票####");
		ticketsSubject.buy();
	}

	public void getAuthority() {
		System.out.println("####获取权限####");
	}
}
