package com.aaron.design.iterator.part2;

/**
 * 定义迭代器(相当于java.util.Iterator)
 * 
 * @author Aaron
 * @date 2017年6月2日
 * @version 1.0
 * @package_name com.aaron.test
 */
interface Iterator {
	public Object next();

	public boolean hasNext();
}