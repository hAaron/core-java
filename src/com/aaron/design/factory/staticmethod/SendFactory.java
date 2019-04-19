package com.aaron.design.factory.staticmethod;

import com.aaron.design.factory.common.ISender;
import com.aaron.design.factory.common.MailSender;
import com.aaron.design.factory.common.SmsSender;

/**
 * 
 * @author Aaron
 * @date 2019年4月19日
 * @version 1.0
 * @package_type com.aaron.design.factory.staticmethod.SendFactory
 */
public class SendFactory {

	@Override
	public static ISender produceSMS() {
		return new SmsSender();
	}

	@Override
	public static ISender produceEmail() {
		return new MailSender();
	}

}
