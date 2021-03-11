package com.aaron.design.iterator.part1;

/**
 * 定义容器角色
 * 
 * @author Aaron
 * @date 2017年6月2日
 * @version 1.0
 * @package_name com.aaron.design.iterator
 */
public interface Aggregate {
    /**
     * 
     * @return
     */
    public Iterator createIterator();
}