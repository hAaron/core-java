package com.aaron.design.factory.abstracts;

/**
 * 抽象工厂模式中，抽象产品 (AbstractProduct) 可能是一个或多个，
 * 从而构成一个或多个产品族(Product Family)。
 * 在只有一个产品族的情况下，抽象工厂模式实际上退化到工厂方法模式。
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.factory.abstracts
 */
public class TestAbstracts {

	public static void main(String[] args) {
		DefaultFactory factory = new DefaultFactory();
		factory.sendSMS();
		factory.sendMail();
	}
}
