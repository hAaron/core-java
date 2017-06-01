package com.aaron.design.observer;

import java.util.*;
import java.io.*;

/**
 * 在主题类中有一个观察者的集合，当调用主题类的某些方法时，自动循环这个集合，调用观察者的方法。
 * 
 * @author Aaron
 * @date 2017年6月1日
 * @version 1.0
 * @package_name com.aaron.design.observer
 */
public class ConcreteSubject implements Subject {
	private LinkedList observerList;
	private Vector strVector;

	public ConcreteSubject() {
		observerList = new LinkedList();
		strVector = new Vector();
	}

	public void attach(Observer o) {
		observerList.add(o);
	}

	public void detach(Observer o) {
		observerList.remove(o);
	}

	public void sendNotify() {
		for (int i = 0; i < observerList.size(); i++) {
			((Observer) observerList.get(i)).update(this);
		}
	}

	public void setState(String act, String str) {
		if (act.equals("ADD")) {
			strVector.add(str);
		} else if (act.equals("DEL")) {
			strVector.remove(str);
		}
	}

	public Vector getState() {
		return strVector;
	}
}