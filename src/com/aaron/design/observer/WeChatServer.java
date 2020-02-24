package com.aaron.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 真实被观察角色--微信公众号（多人订阅，通知）
 * 
 * @author Aaron
 * @date 2020年2月24日
 * @version 1.0
 * @package_type com.aaron.design.observer.WeChatServer
 */
public class WeChatServer implements Observeable {
	List<AbstractObserver> observers;// 观察者角色集合
	String msg;

	public WeChatServer() {
		observers = new ArrayList<AbstractObserver>();
	}

	@Override
	public void registerObserve(AbstractObserver observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserve(AbstractObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void noticefyObserve() {
		for (AbstractObserver abstractObserver : observers) {
			abstractObserver.update(msg);
		}
	}

	public void sendMsgByServer(String msg) {
		this.msg = msg;
		System.out.println("微信公众号发送消息：" + msg);
		noticefyObserve();
	}

}
