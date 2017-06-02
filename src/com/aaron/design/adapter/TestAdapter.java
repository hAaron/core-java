package com.aaron.design.adapter;

/**
 * 适配器模式将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的类的兼容性问题。
 * 主要分为三类：类的适配器模式、对象的适配器模式、接口的适配器模式
 * 
 * @author Aaron
 * @date 2017年6月2日
 * @version 1.0
 * @package_name com.aaron.design.adapter
 */
public class TestAdapter {
	public static void main(String[] args) {

		// 类适配器
		JobTarget jobTarget1 = new AdapterClass();
		jobTarget1.speakEnglish();
		jobTarget1.speakJapanese();
		jobTarget1.speakFrench();
		
		System.out.println(".............................................");
		// 对象适配器
		PersonSource personSource = new PersonSource();
		JobTarget jobTarget2 = new AdapterObject(personSource);
		jobTarget2.speakEnglish();
		jobTarget2.speakJapanese();
		jobTarget2.speakFrench();
	}

}
