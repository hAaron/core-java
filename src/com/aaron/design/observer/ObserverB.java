package com.aaron.design.observer;

import java.util.Vector;

/**
 * 
 * @author Aaron
 * @date 2017年6月1日
 * @version 1.0
 * @package_name com.aaron.design.observer
 */
public class ObserverB implements Observer {
	private Vector strVector;

	public ObserverB() {
		strVector = new Vector();
	}

	@Override
	public void update(Subject subject) {
		strVector = (Vector) (subject.getState()).clone();
		// ----- Sorted vector ---------------------------
		for (int i = strVector.size(); --i >= 0;) {
			for (int j = 0; j < i; j++) {
				String str1 = (String) strVector.get(j);
				String str2 = (String) strVector.get(j + 1);
				if ((str1.compareTo(str2)) > 0) {
					strVector.setElementAt(str2, j);
					strVector.setElementAt(str1, j + 1);
				}
			}
		}
		System.out.println("----- ObserverB will be updated -----");
		for (int i = 0; i < strVector.size(); i++) {
			System.out.println("Num " + i + " is :" + (String) strVector.get(i));
		}
	}

}