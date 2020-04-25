package com.aaron.design.visitor;

/**
 * 抽象节点(Node)角色：声明一个接受操作，接受一个访问者对象作为一个参数。
 * 
 * @author Aaron
 * @date 2017年6月11日
 * @version 1.0
 * @package_name com.aaron.design.visitor
 */
public abstract class Node {
	/**
	 * 接受操作
	 */
	public abstract void accept(Visitor visitor);
}
