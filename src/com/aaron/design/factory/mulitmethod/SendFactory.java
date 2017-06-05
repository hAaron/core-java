package com.aaron.design.factory.mulitmethod;

import com.aaron.design.factory.common.ISender;
import com.aaron.design.factory.common.MailSender;
import com.aaron.design.factory.common.SmsSender;

public class SendFactory {
	
	public ISender produceSMS(){
		return new SmsSender();
	}
	
	public ISender produceEmail(){
		return new MailSender();
	}

}
