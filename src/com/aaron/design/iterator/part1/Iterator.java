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
    public abstract void first();

    public abstract void next();

    public abstract boolean isDone();

    public abstract void currentItem();
}