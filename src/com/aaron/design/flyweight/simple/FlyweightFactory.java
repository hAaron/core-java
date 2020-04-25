package com.aaron.design.flyweight.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂(FlyweightFactory)角色
 * ：本角色负责创建和管理享元角色。本角色必须保证享元对象可以被系统适当地共享。当一个客户端对象调用一个享元对象的时候
 * ，享元工厂角色会检查系统中是否已经有一个符合要求的享元对象
 * 。如果已经有了，享元工厂角色就应当提供这个已有的享元对象；如果系统中没有一个适当的享元对象的话，享元工厂角色就应当创建一个合适的享元对象。
 * 
 * 享元工厂角色类，必须指出的是，客户端不可以直接将具体享元类实例化，而必须通过一个工厂对象，
 * 利用一个factory()方法得到享元对象。一般而言，享元工厂对象在整个系统中只有一个，因此也可以使用单例模式。
 * 当客户端需要单纯享元对象的时候，需要调用享元工厂的factory()方法，并传入所需的单纯享元对象的内蕴状态， 由工厂方法产生所需要的享元对象。
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.flyweight.simple
 */
public class FlyweightFactory {
	private Map<Character, Flyweight> files = new HashMap<Character, Flyweight>();

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
