package com.aaron.test;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;


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
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		queue.offer(11);
		
		Set<String> sets = new HashSet<String>();
		sets.add("2");
		sets.add("4");
		sets.add("1");
		sets.add("3");
		sets.add("0");
		for (String string : sets) {
			System.out.print(string+"=");
		}
		System.out.println("###################");
		Queue<String> queue2 = new LinkedList<String>();
		queue2.add("2");
		queue2.add("4");
		queue2.add("1");
		queue2.add("3");
		queue2.add("0");
		for (String string : queue2) {
			System.out.print(string+"=");
			System.out.println(string.hashCode());
		}
		
		
 	}

}
