package com.aaron.design.factory.staticmethod;

import com.aaron.design.factory.common.ISender;
import com.aaron.design.factory.common.MailSender;
import com.aaron.design.factory.common.SmsSender;

public class SendFactory {
	
	public static ISender produceSMS(){
		return new SmsSender();
	}
	
	public static ISender produceEmail(){
		return new MailSender();
	}

}
