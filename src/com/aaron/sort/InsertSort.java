package com.aaron.sort;

import java.util.Arrays;

/**
 * @Author Aaron
 * @Date 创建时间：2016-5-22
 * @Version 1.0
 * 
 * @Project_Package_Description core-utils || com.hbaaron.sort
 * @Function_Description 直接插入排序--基本思想：在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排
 *                       好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数 也是排好顺序的。如此反复循环，直到全部排好顺序。
 * 
 */
public class InsertSort {

	public static void sort(int[] a) {
		System.out.println("######直接插入排序########");
		int temp = 0;
		for (int i = 1; i < a.length; i++) {
			int j = i - 1;
			temp = a[i];
			for (; j >= 0 && temp < a[j]; j--) {
				a[j + 1] = a[j]; // 将大于temp的值整体后移一个单位
			}
			a[j + 1] = temp;
		}
		System.out.println(Arrays.toString(a));
	}

}
