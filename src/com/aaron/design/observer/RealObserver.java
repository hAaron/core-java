package com.aaron.design.observer;

/**
 * 真实观察者角色
 * 
 * @author Aaron
 * @date 2020年2月24日
 * @version 1.0
 * @package_type com.aaron.design.observer.RealObserver
 */
public class RealObserver implements AbstractObserver {
	String name;
	String msg;

	public RealObserver() {
	}
	
	public RealObserver(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void update(String msg) {
		System.out.println(name + " 收到订阅号发的消息：" + msg);
	}

}
