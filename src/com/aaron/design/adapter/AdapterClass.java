package com.aaron.design.adapter;

/**
 * Adapter类继承了Person类，而在Java这种单继承的语言中也就意味着，
 * 他不可能再去继承其他的类了，这样也就是这个适配器只为Person这一个类服务。所以称其为类适配模式。
 * 
 * 当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可。
 * 
 * @author Aaron
 * @date 2017年6月2日
 * @version 1.0
 * @package_name com.aaron.design.adapter
 */
public class AdapterClass extends PersonSource implements JobTarget {

	public void speakFrench() {
		System.out.println("类适配器，会法语。。。");
	}
}
