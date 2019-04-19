package com.aaron.design.iterator.part2;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义迭代器角色
 * 
 * @author Aaron
 * @date 2017年6月2日
 * @version 1.0
 * @package_name com.aaron.test
 */
class ConcreteIterator implements Iterator {

	private List list = new ArrayList();
	private int cursor = 0;

	public ConcreteIterator(List list) {
		this.list = list;
	}

	@Override
	public boolean hasNext() {
		if (cursor == list.size()) {
			return false;
		}
		return true;
	}

	@Override
	public Object next() {
		Object obj = null;
		if (this.hasNext()) {
			obj = this.list.get(cursor++);
		}
		return obj;
	}
}
