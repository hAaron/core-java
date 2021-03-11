package com.aaron.design.factory.mulitmethod;

import com.aaron.design.factory.common.ISender;
import com.aaron.design.factory.common.MailSender;
import com.aaron.design.factory.common.SmsSender;

/**
 * 
 * @author Aaron
 * @date 2019年4月19日
 * @version 1.0
 * @package_type com.aaron.design.factory.mulitmethod.SendFactory
 */
public class SendFactory {

    public ISender produceSMS() {
        return new SmsSender();
    }

    public ISender produceEmail() {
        return new MailSender();
    }

}
