package com.aaron.design.iterator.part2;

/**
 * 定义容器角色(如List,Set,Map)
 * 
 * @author Aaron
 * @date 2017年6月2日
 * @version 1.0
 * @package_name com.aaron.test
 */
interface Aggregate {
    public void add(Object obj);

    public void remove(Object obj);

    public Iterator iterator();
}
