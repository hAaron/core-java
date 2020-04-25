package com.aaron.design.observer;

/**
 * 观察者模式 </br>
 * 观察者模式需要有一个主题，还有一个或多个观察者。 </br>
 * 在主题类中有一个观察者的集合。当调用主题类的某些方法时，自动循环这个集合，调用观察者的方法。
 * 
 * 定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。</br>
 * 这个主题对象在状态发生变化时会通知所有的观察者对象，使他们能够自动更新自己。
 * 
 * @author Aaron
 * @date 2017年6月2日
 * @version 1.0
 * @package_name com.aaron.design.observer
 */
public class TestObserver {
	public static void main(String[] args) {
		AbstractObserver observer1 = new RealObserver("aaa");
		AbstractObserver observer2 = new RealObserver("bbb");
		AbstractObserver observer3 = new RealObserver("ccc");
		WeChatServer server = new WeChatServer();
		server.registerObserve(observer1);
		server.registerObserve(observer2);
		server.registerObserve(observer3);
		server.sendMsgByServer("hello");

		server.removeObserve(observer2);
		server.sendMsgByServer("world");
		
	}
}