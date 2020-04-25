package com.aaron.design.observer;

/**
 * 抽象观察者角色
 * 
 * @author Aaron
 * @date 2019年4月19日
 * @version 1.0
 * @package_type com.aaron.design.observer.Observer
 */
public interface AbstractObserver {
	/**
	 * 更新收到的消息
	 * 
	 * @param msg
	 */
	public void update(String msg);
}