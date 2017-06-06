package com.aaron.design.bridge;

/**
 * 
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.bridge
 */
public class Woman extends AbstractPeople{
	@Override
	void run() {
		super.run();
		System.out.print("女人开着-");  
		road.run();
	}
}
