package com.aaron.design.iterator.part1;

/**
 * 定义迭代器角色
 * 
 * @author Aaron
 * @date 2017年6月2日
 * @version 1.0
 * @package_name com.aaron.design.iterator
 */
public interface Iterator {
	public abstract void First();

	public abstract void Next();

	public abstract boolean IsDone();

	public abstract void CurrentItem();
}