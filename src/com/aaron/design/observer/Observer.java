package com.aaron.design.observer;

/**
 * 
 * @author Aaron
 * @date 2019年4月19日
 * @version 1.0
 * @package_type com.aaron.design.observer.Observer
 */
public interface Observer {
	/**
	 * 更新
	 * 
	 * @param s
	 */
	public void update(Subject s);
}