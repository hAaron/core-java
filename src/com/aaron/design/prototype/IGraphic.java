package com.aaron.design.prototype;

import java.io.*;

/**
 * 抽象原型角色:这是一个抽象角色，通常由一个Java接口或Java抽象类实现。此角色给出所有的具体原型类所需的接口。
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.prototype
 */
public interface IGraphic extends Cloneable, Serializable {
	public String getName();

	public void setName(String gName);
}