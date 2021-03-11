package com.aaron.design.factory.common;

/**
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.factory.common
 */
public class SmsSender implements ISender {

    @Override
    public void send() {
        System.out.println("####发送短信####");
    }
}