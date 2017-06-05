package com.aaron.design.proxy.staticp;

/**
 * 主题实现类，真实对象
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.proxy.staticp
 */
public class BuyReal implements TicketsSubject {

	@Override
	public void buy() {
		System.out.println("####真实对象购买车票#####");
	}

}
