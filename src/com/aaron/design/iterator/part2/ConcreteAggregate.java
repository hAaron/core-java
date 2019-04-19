package com.aaron.design.iterator.part2;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义具体容器角色(如LinkedList，TreeSet，hashMap)
 * 
 * @author Aaron
 * @date 2017年6月2日
 * @version 1.0
 * @package_name com.aaron.test
 */
class ConcreteAggregate implements Aggregate {
	private List list = new ArrayList();

	@Override
	public void add(Object obj) {
		list.add(obj);
	}

	@Override
	public Iterator iterator() {
		return new ConcreteIterator(list);// list.iterator();
	}

	@Override
	public void remove(Object obj) {
		list.remove(obj);
	}
}