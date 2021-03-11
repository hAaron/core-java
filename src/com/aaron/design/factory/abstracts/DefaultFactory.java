package com.aaron.design.factory.abstracts;

import com.aaron.design.factory.common.MailSender;
import com.aaron.design.factory.common.SmsSender;

/**
 * 具体工厂类
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.factory.abstracts
 */
public class DefaultFactory implements AbstractFactory {

    @Override
    public void sendSMS() {
        new SmsSender().send();
    }

    @Override
    public void sendMail() {
        new MailSender().send();
    }

}
