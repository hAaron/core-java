package com.aaron.design.prototype;

import java.lang.*;
import java.io.*;

/**
 * 具体原型（Concrete Prototype）角色：被复制的对象。此角色需要实现抽象的原型角色所要求的接口。
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.prototype
 */
public abstract class Graphic implements IGraphic {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	/**
	 * 克隆自身的方法
	 */
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Do not support clone !!!");
			throw new InternalError();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String gName) {
		name = gName;
	}

	public abstract void DoSomething();
}