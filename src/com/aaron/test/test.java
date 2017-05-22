package com.aaron.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.apache.hadoop.util.StringUtils;

public class test {
	
	public static void main(String[] args) {
		int[] a = new int[10000];
		Random random = new Random();
		for(int i=0;i<9999;i++){
			a[i]=random.nextInt(100000);
		}
		System.out.println(Arrays.toString(a));
	}

}
