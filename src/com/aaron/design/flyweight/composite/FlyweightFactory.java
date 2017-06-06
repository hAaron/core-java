package com.aaron.design.flyweight.composite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 享元工厂(FlyweightFactory)角色 ：本角
 * 色负责创建和管理享元角色。本角色必须保证享元对象可以被系统适当地共享。当一个客户端对象调用一个享元对象的时候，享元工厂角色会检查系统中是否已经有
 * 一个符合要求的享元对象。如果已经有了，享元工厂角色就应当提供这个已有的享元对象；如果系统中没有一个适当的享元对象的话，享元工厂角色就应当创建一个
 * 合适的享元对象。
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.flyweight.composite
 */
public class FlyweightFactory {
	private Map<Character, Flyweight> files = new HashMap<Character, Flyweight>();

	/**
	 * 复合享元工厂方法
	 */
	public Flyweight factory(List<Character> compositeState) {
		ConcreteCompositeFlyweight compositeFly = new ConcreteCompositeFlyweight();

		for (Character state : compositeState) {
			compositeFly.add(state, this.factory(state));
		}

		return compositeFly;
	}

	/**
	 * 单纯享元工厂方法
	 */
	public Flyweight factory(Character state) {
		// 先从缓存中查找对象
		Flyweight fly = files.get(state);
		if (fly == null) {
			// 如果对象不存在则创建一个新的Flyweight对象
			fly = new ConcreteFlyweight(state);
			// 把这个新的Flyweight对象添加到缓存中
			files.put(state, fly);
		}
		return fly;
	}
}
