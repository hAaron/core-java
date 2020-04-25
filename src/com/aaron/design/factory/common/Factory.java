package com.aaron.design.factory.common;

/**
 * 普通工厂模式，就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.factory.common
 */
public class Factory {

	public ISender createSender(String type) {
		if (type.equals("sms")) {
			return new SmsSender();
		} else if (type.equals("email")) {
			return new MailSender();
		} else {
			return new SmsSender();
		}
	}
}