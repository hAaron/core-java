package com.aaron.util.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap 用法
 * 
 * @author Aaron
 * @date 2018年7月26日
 * @version 1.0
 * @package_type com.aaron.util.collections.ConcurrentHashMapUtil
 */
public class ConcurrentHashMapUtil {
	public static Map<Integer, String> hashMap = new HashMap<Integer, String>();
	public static Map<Integer, String> hashTable = new Hashtable<Integer, String>();
	public static Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<Integer, String>();

	public static void main(String[] args) {
		int s = 2000000;
		int e = 4000000;
		long start = System.currentTimeMillis();
		// testHashMap(s, e); //线程不安全,多线程情况下出现错误结果（耗时/ms：31911）
		// testHashtable(s, e); //线程安全，不过对比ConcurrentHashMap，耗时长（耗时/ms：35825）
		testConcurrentHashMap(s, e);// 线程安全，锁分段技术（耗时/ms：31723）
		long end = System.currentTimeMillis();
		System.out.println("耗时/ms：" + (end - start));
	}

	private static void testHashMap(final int s, final int e) {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < s; i++) {
					hashMap.put(i, String.valueOf(i));
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				for (int i = s; i < e; i++) {
					hashMap.put(i, String.valueOf(i));
				}
			}
		};
		t1.start();
		t2.start();
		// 放完数据后，从map中取出数据，如果map是线程安全的，那么取出的entry应该和放进去的一一对应
		for (int i = 0; i < e; i++) {
			System.out.println(i + "=" + hashMap.get(i));
		}
	}

	private static void testHashtable(final int s, final int e) {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < s; i++) {
					hashTable.put(i, String.valueOf(i));
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				for (int i = s; i < e; i++) {
					hashTable.put(i, String.valueOf(i));
				}
			}
		};
		t1.start();
		t2.start();
		// 放完数据后，从map中取出数据，如果map是线程安全的，那么取出的entry应该和放进去的一一对应
		for (int i = 0; i < e; i++) {
			System.out.println(i + "=" + hashTable.get(i));
		}
	}

	private static void testConcurrentHashMap(final int s, final int e) {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < s; i++) {
					concurrentHashMap.put(i, String.valueOf(i));
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				for (int i = s; i < e; i++) {
					concurrentHashMap.put(i, String.valueOf(i));
				}
			}
		};
		t1.start();
		t2.start();
		for (int i = 0; i < e; i++) {
			System.out.println(i + "=" + concurrentHashMap.get(i));
		}
	}
}
