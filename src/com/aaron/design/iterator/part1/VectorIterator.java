package com.aaron.design.iterator.part1;

import java.util.Vector;

/**
 * 定义具体迭代器角色
 * 
 * @author Aaron
 * @date 2017年6月2日
 * @version 1.0
 * @package_name com.aaron.design.iterator
 */
public class VectorIterator implements Iterator {
	private Vector data = new Vector();
	private int cursor = 0;

	public VectorIterator(Vector _data) {
		data = _data;
	}

	public void First() {
		// cursor = 0;
		cursor = (data.size() - 1);
	}

	public void Next() {
		// cursor++;
		cursor--;
	}

	public boolean IsDone() {
		// return (cursor >= data.size());
		return (cursor < 0);
	}

	public void CurrentItem() {
		if (IsDone()) {
			System.out.println("Reach the end of the vector");
		} else {
			System.out.println("Number " + cursor + ": " + data.get(cursor));
		}
	}
}