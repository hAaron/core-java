package com.aaron.design.bridge;

/**
 * 
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.bridge
 */
public class Car extends AbstractCar {
	@Override
	void run() {
		super.run();
		System.out.print("小汽车-");
	}
}
