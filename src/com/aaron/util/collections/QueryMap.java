package com.aaron.util.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Map遍历方法
 * 
 * @author Aaron
 * @date 2017年5月22日
 * @version 1.0
 * @package_name com.aaron.util.collections
 */
public class QueryMap {

	/**
	 * 第一种：普遍使用，二次取值。 通过Map.keySet遍历key和value
	 * 
	 * @param map
	 */
	public static void query1(Map<String, String> map) {
		System.out.println("通过Map.keySet遍历key和value：");
		for (String key : map.keySet()) {
			System.out.println("key= " + key + " and value= " + map.get(key));
		}
	}

	/**
	 * 第二种：通过Map.entrySet使用iterator遍历key和value
	 * 
	 * @param map
	 */
	public static void query2(Map<String, String> map) {
		System.out.println("通过Map.entrySet使用iterator遍历key和value：");
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println("key= " + entry.getKey() + " and value= "
					+ entry.getValue());
		}
	}

	/**
	 * 第三种：推荐，尤其是容量大时.通过Map.entrySet遍历key和value
	 * 
	 * @param map
	 */
	public static void query3(Map<String, String> map) {
		System.out.println("通过Map.entrySet遍历key和value");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("key= " + entry.getKey() + " and value= "
					+ entry.getValue());
		}
	}

	/**
	 * 第四种 通过Map.values()遍历所有的value，但不能遍历key
	 * 
	 * @param map
	 */
	public static void query4(Map<String, String> map) {
		// 第四种
		System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
		for (String v : map.values()) {
			System.out.println("value= " + v);
		}
	}

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
		map.put("4", "d");
		map.put("5", "e");
		map.put("6", "f");
		query3(map);
	}

}
