package com.aaron.design.prototype;

/**
 * 具体原型（Concrete Prototype）角色：被复制的对象。此角色需要实现抽象的原型角色所要求的接口(通过实现Cloneable接口实现)。
 * 
 * @author Aaron
 * @date 2019年6月21日
 * @version 1.0
 * @package_type com.aaron.design.prototype.ConcretePrototype2
 */
public class ConcretePrototype2 implements Prototype, Cloneable {
	/**
	 * 对象属性
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Prototype cloneMethod() {
		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return (Prototype) object;
	}

	@Override
	public String toString() {
		return "ConcretePrototype2 [name=" + name + "]";
	}

}
