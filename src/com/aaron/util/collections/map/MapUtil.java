package com.aaron.util.collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Map集合工具类--重构数据格式
 * 
 * @author Aaron
 * @date 2017年5月22日
 * @version 1.0
 * @package_name com.aaron.util.collections
 */
public class MapUtil {

	/**
	 * 将一个List<Map<String,Object>> 的集合包装成 Map<String,List<Map<String,Object>>>
	 * 比如 时间=List<Map<String,Object>> 格式
	 * 
	 * @param datas
	 *            List<Map<String,Object>>集合
	 * @param param
	 *            包装成Map集合的key值
	 * @return
	 */
	public static Map<String, List<Map<String, Object>>> build(
			List<Map<String, Object>> datas, Object key) {
		Map<String, List<Map<String, Object>>> resultData = new LinkedHashMap<String, List<Map<String, Object>>>();
		for (Map<String, Object> data : datas) {
			String keyString = String.valueOf(data.get(key));
			if (!resultData.containsKey(keyString)) {
				resultData.put(keyString, new ArrayList<Map<String, Object>>());
			}
			resultData.get(keyString).add(data);
		}
		return resultData;
	}

	public static void main(String[] args) {
		List<Map<String, Object>> arrays = new ArrayList<Map<String, Object>>();
		Map<String, Object> array1 = new HashMap<String, Object>();
		array1.put("time", "2015");
		array1.put("name", "hello3");
		Map<String, Object> array2 = new HashMap<String, Object>();
		array2.put("time", "2015");
		array2.put("name1", "hello2");
		Map<String, Object> array3 = new HashMap<String, Object>();
		array3.put("time", "2016");
		array3.put("name", "hello");
		Map<String, Object> array4 = new HashMap<String, Object>();
		array4.put("time", "2015");
		array4.put("name", "hello");
		Map<String, Object> array5 = new HashMap<String, Object>();
		array5.put("time", "2017");
		array5.put("name", "hello");
		arrays.add(array1);
		arrays.add(array2);
		arrays.add(array3);
		arrays.add(array4);
		arrays.add(array5);
		Map<String, List<Map<String, Object>>> result = build(arrays, "time");
		System.out.println(build(arrays, "time"));
	}
}
