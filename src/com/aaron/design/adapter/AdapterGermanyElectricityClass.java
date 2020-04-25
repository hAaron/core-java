package com.aaron.design.adapter;

/**
 * 当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可。
 * 
 * @author Aaron
 * @date 2019年6月20日
 * @version 1.0
 * @package_type com.aaron.design.adapter.AdapterGermanyElectricityClass
 */
public class AdapterGermanyElectricityClass extends ChinaElectricityImpl implements IGermanyElectricity {

	@Override
	public void use110v() {
		System.out.println("类适配器：此时在德国的电压标准为110v，需要一个适配器来适应当地的电压：");
		use220v();
	}

}
