package com.aaron.design.factory.common;

/**
 * 普通工厂模式，就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.factory.common
 */
public class Test {

    public static void main(String[] args) {
        Factory myFactory = new Factory();
        ISender smSender = myFactory.createSender("sms");
        smSender.send();

        ISender emailSender = myFactory.createSender("email");
        emailSender.send();
    }
}
