package com.aaron.design.iterator.part2;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试端
 * 
 * @author Aaron
 * @date 2017年6月2日
 * @version 1.0
 * @package_name com.aaron.test
 */
public class Client {
	public static void main(String[] args) {
		Aggregate ag = new ConcreteAggregate();
		ag.add("小明");
		ag.add("小红");
		ag.add("小刚");
		Iterator it = ag.iterator();
		while (it.hasNext()) {
			String str = (String) it.next();
			System.out.println(str);
		}

	}
}
