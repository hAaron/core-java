package com.aaron.design.prototype;

/**
 * 具体原型（Concrete Prototype）角色：被复制的对象。此角色需要实现抽象的原型角色所要求的接口(自身实现)。
 * 
 * @author Aaron
 * @date 2019年6月21日
 * @version 1.0
 * @package_type com.aaron.design.prototype.ConcretePrototype
 */
public class ConcretePrototype implements Prototype {

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

	/**
	 * 实现接口的clone方法，返回新创建的对象
	 */
	@Override
	public Prototype cloneMethod() {
		// 新创建的对象
		ConcretePrototype prototype = new ConcretePrototype();
		prototype.setName(this.getName());
		return prototype;
	}

	@Override
	public String toString() {
		return "ConcretePrototype [name=" + name + "]";
	}

}
