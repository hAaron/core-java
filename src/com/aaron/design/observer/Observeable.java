package com.aaron.design.observer;

/**
 * 抽象被观察角色
 * 
 * @author Aaron
 * @date 2020年2月24日
 * @version 1.0
 * @package_type com.aaron.design.observer.Observeable
 */
public interface Observeable {

	void registerObserve(AbstractObserver observer);

	void removeObserve(AbstractObserver observer);

	void noticefyObserve();

}
