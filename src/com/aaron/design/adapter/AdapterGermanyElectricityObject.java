package com.aaron.design.adapter;

/**
 * 对象的适配器模式 当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个对象适配类，</br>
 * 持有原类的一个实例，在对象适配类的方法中，调用实例的方法就行。
 * 
 * @author Aaron
 * @date 2019年6月20日
 * @version 1.0
 * @package_type com.aaron.design.adapter.AdapterGermanyElectricityObject
 */
public class AdapterGermanyElectricityObject implements IGermanyElectricity {
	IChinaElectricity chinaElectricity;

	public AdapterGermanyElectricityObject(IChinaElectricity chinaElectricity) {
		this.chinaElectricity = chinaElectricity;
	}

	@Override
	public void use110v() {
		System.out.println("对象适配器：此时在德国的电压标准为110v，需要一个适配器来适应当地的电压：");
		chinaElectricity.use220v();
	}

}
