package com.aaron.design.factory.mulitmethod;

import com.aaron.design.factory.common.ISender;

/**
 * 多个工厂方法模式，是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错， 则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.factory.mulitmethod
 */
public class Test {

    public static void main(String[] args) {
        SendFactory myFactory = new SendFactory();
        ISender smSender = myFactory.produceSMS();
        smSender.send();

        ISender emailSender = myFactory.produceEmail();
        emailSender.send();
    }
}
