package com.aaron.design.prototype;

/**
 * 抽象原型角色:这是一个抽象角色，通常由一个Java接口或Java抽象类实现。此角色给出所有的具体原型类所需的接口。
 * 
 * @author Aaron
 * @date 2019年6月21日
 * @version 1.0
 * @package_type com.aaron.design.prototype.Prototype
 */
public interface Prototype {

	/**
	 * 定义一个clone接口
	 * 
	 * @return
	 */
	public Prototype cloneMethod();

}
