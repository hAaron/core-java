package com.aaron.util.xml;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author Aaron
 * @date 2017年5月22日
 * @version 1.0
 * @package_name com.aaron.util.xml
 */
public class hbxml {
	public static void main(String[] args) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", 1);
		map.put("b", "11");
		map.put("startTime", "2016-05-23 19:00:00");

		System.out.println(map.keySet());
		System.out.println(map.entrySet());
		Map resultMap = new HashMap();
		for (Entry<String, Object> string : map.entrySet()) {
			string.getKey();
			string.getValue();
			System.out.println(string);
		}
		System.out.println(resultMap);
	}
}
