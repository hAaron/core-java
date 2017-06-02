package com.aaron.design.adapter;

/**
 * 对象的适配器模式 当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个对象适配类，</br>
 * 持有原类的一个实例，在对象适配类的方法中，调用实例的方法就行。
 * 
 * @author Aaron
 * @date 2017年6月2日
 * @version 1.0
 * @package_name com.aaron.design.adapter
 */
public class AdapterObject implements JobTarget {

	PersonSource personSource;

	public AdapterObject() {
		super();
	}

	public AdapterObject(PersonSource personSource) {
		super();
		this.personSource = personSource;
	}

	@Override
	public void speakEnglish() {
		personSource.speakEnglish();
	}

	@Override
	public void speakJapanese() {
		personSource.speakJapanese();
	}

	@Override
	public void speakFrench() {
		System.out.println("对象适配器，会法语。。。");
	}

}
