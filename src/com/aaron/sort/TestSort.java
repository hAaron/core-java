package com.aaron.sort;

import java.util.Arrays;
import java.util.Random;

public class TestSort {
	public static void main(String[] args) {
//		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62,
//				99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };
		
		int[] a = new int[1000];
		Random random = new Random();
		for(int i=0;i<999;i++){
			a[i]=random.nextInt(100000);
		}
		System.out.println(Arrays.toString(a));
		long startTime= 0;
		long endTime=0;
		
		startTime = System.currentTimeMillis();
		InsertSort.sort(a);// 直接插入排序
		endTime = System.currentTimeMillis();
		System.out.println("#######【直接插入排序】耗时："+(endTime-startTime));
		System.out.println();
		
		startTime = System.currentTimeMillis();
		ShellSort.sort(a);// 希尔排序（最小增量排序）
		endTime = System.currentTimeMillis();
		System.out.println("#######【希尔排序】耗时："+(endTime-startTime));
		System.out.println();
		
		startTime = System.currentTimeMillis();
		SelectSort.sort(a);// 简单选择排序
		endTime = System.currentTimeMillis();
		System.out.println("#######【简单选择排序】耗时："+(endTime-startTime));
		System.out.println();
		
		startTime = System.currentTimeMillis();
		HeapSort.sort(a);// 堆排序
		endTime = System.currentTimeMillis();
		System.out.println("#######【堆排序】耗时："+(endTime-startTime));
		System.out.println();
		
		startTime = System.currentTimeMillis();
		BubbleSort.sort(a);// 冒泡排序
		endTime = System.currentTimeMillis();
		System.out.println("#######【冒泡排序】耗时："+(endTime-startTime));
		System.out.println();
		
		startTime = System.currentTimeMillis();
		QuickSort.sort(a);// 快速排序
		endTime = System.currentTimeMillis();
		System.out.println("#######【快速排序】耗时："+(endTime-startTime));
		System.out.println();
		
		startTime = System.currentTimeMillis();
		MergingSort.sort(a);// 归并排序
		endTime = System.currentTimeMillis();
		System.out.println("#######【归并排序】耗时："+(endTime-startTime));
		System.out.println();
		
		startTime = System.currentTimeMillis();
		RadixSort.sort(a);// 基数排序
		endTime = System.currentTimeMillis();
		System.out.println("#######【基数排序】耗时："+(endTime-startTime));
		System.out.println();
		
	}

}
