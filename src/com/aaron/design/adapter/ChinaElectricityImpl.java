package com.aaron.design.adapter;

/**
 * 目标接口
 * 
 * @author Aaron
 * @date 2019年6月20日
 * @version 1.0
 * @package_type com.aaron.design.adapter.ChinaElectricityImpl
 */
public class ChinaElectricityImpl implements IChinaElectricity {

	@Override
	public void use220v() {
		System.out.println("使用220v电压");
	}

}
