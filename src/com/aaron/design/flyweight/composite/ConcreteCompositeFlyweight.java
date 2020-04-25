package com.aaron.design.flyweight.composite;

import java.util.HashMap;
import java.util.Map;

/**
 * 复合享元(ConcreteCompositeFlyweight)角色
 * 复合享元角色所代表的对象是不可以共享的，但是一个复合享元对象可以分解成为多个本身是单纯享元对象的组合。复合享元角色又称作不可共享的享元对象。
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.flyweight.composite
 */
public class ConcreteCompositeFlyweight implements Flyweight {

	private Map<Character, Flyweight> files = new HashMap<Character, Flyweight>();

	/**
	 * 增加一个新的单纯享元对象到聚集中
	 */
	public void add(Character key, Flyweight fly) {
		files.put(key, fly);
	}

	/**
	 * 外蕴状态作为参数传入到方法中
	 */
	@Override
	public void operation(String state) {
		Flyweight fly = null;
		for (Object o : files.keySet()) {
			fly = files.get(o);
			fly.operation(state);
		}

	}

}
