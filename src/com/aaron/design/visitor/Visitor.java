package com.aaron.design.visitor;

/**
 * 抽象访问者(Visitor)角色：声明了一个或者多个方法操作，形成所有的具体访问者角色必须实现的接口。
 * 
 * @author Aaron
 * @date 2017年6月11日
 * @version 1.0
 * @package_name com.aaron.design.visitor
 */
public interface Visitor {
	/**
	 * 对应于NodeA的访问操作
	 */
	public void visit(NodeA node);

	/**
	 * 对应于NodeB的访问操作
	 */
	public void visit(NodeB node);
}
