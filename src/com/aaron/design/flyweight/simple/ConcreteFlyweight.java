package com.aaron.design.flyweight.simple;

/**
 * 具体享元(ConcreteFlyweight)角色：实现抽象享元角色所规定出的接口。如果有内蕴状态的话，必须负责为内蕴状态提供存储空间。
 * 具体享元角色类ConcreteFlyweight有一个内蕴状态，在本例中一个Character类型的intrinsicState属性代表，
 * 它的值应当在享元对象被创建时赋予。所有的内蕴状态在对象创建之后，就不会再改变了。
 * 如果一个享元对象有外蕴状态的话，所有的外部状态都必须存储在客户端，在使用享元对象时，
 * 再由客户端传入享元对象。这里只有一个外蕴状态，operation()方法的参数state就是由外部传入的外蕴状态。
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.flyweight.simple
 */
public class ConcreteFlyweight implements Flyweight {
	private Character intrinsicState = null;

	/**
	 * 构造函数，内蕴状态作为参数传入
	 * 
	 * @param state
	 */
	public ConcreteFlyweight(Character state) {
		this.intrinsicState = state;
	}

	/**
	 * 外蕴状态作为参数传入方法中，改变方法的行为， 但是并不改变对象的内蕴状态。
	 */
	@Override
	public void operation(String state) {
		// TODO Auto-generated method stub
		System.out.println("内蕴状态Intrinsic State = " + this.intrinsicState);
		System.out.println("外蕴状态Extrinsic State = " + state);
	}

}
