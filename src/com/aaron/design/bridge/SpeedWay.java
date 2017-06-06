package com.aaron.design.bridge;

/**
 * 
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.bridge
 */
public class SpeedWay extends AbstractRoad {
	@Override
	void run() {
		super.run();
		aCar.run();
		System.out.println("在高速公路行驶");
	}
}
