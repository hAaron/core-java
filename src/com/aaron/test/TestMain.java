package com.aaron.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

import org.apache.hadoop.util.StringUtils;

public class TestMain {
	
	public static void main(String[] args) {
		int[] a = new int[100];
		Random random = new Random();
		for(int i=0;i<99;i++){
			a[i]=random.nextInt(1000);
		}
		System.out.println(Arrays.toString(a));
		
		Stack<String> stack = new Stack<String>();
		stack.push("11");
		stack.push("22");
		stack.push("33");
		stack.push("44");
		while(stack.iterator().hasNext()){
			System.out.println(stack.pop());
		}
		stack.size();
		Set<String> set = new HashSet<>();
		set.add("333");
		System.out.println(set.contains("3333"));
	}

}
