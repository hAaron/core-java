package com.aaron.algorithm.fibonacci;

/**
 * 斐波拉契数列 斐波那契数列指的是这样一个数列 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144,
 * 233，377，610，987，1597，2584，4181，6765，10946，17711，28657，46368……
 * 特别指出：第0项是0，第1项是第一个1。 这个数列从第三项开始，每一项都等于前两项之和。
 * 
 * @author Aaron
 * @date 2019年1月14日
 * @version 1.0
 * @package_type com.aaron.algorithm.fibonacci.Fibonacci1
 */
public class Fibonacci {

	/**
	 * 线性递归实现（这种方法很直观，很容易理解，但是效率很低，应尽量避免，不符合递归调用时的合成效益准测）
	 * 
	 * @param n
	 * @return
	 */
	public static int FibonacciRecursively(int n) {
		if (n < 2)
			return n;
		else
			return FibonacciRecursively(n - 1) + FibonacciRecursively(n - 2);
	}

	/**
	 * 尾递归实现，这里需要提供两个累加器：acc1和acc2，调用时acc1赋值0，acc2赋值1
	 * 
	 * @param n
	 * @param acc1
	 * @param acc2
	 * @return
	 */
	public static int FibonacciTailRecursively(int n, int acc1, int acc2) {
		if (n == 0)
			return acc1;
		else
			return FibonacciTailRecursively(n - 1, acc2, acc1 + acc2);
	}

	public static void main(String[] args) {
		long total = 100;
		long st1 = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			System.out.print(FibonacciRecursively(i) + " ");
		}
		long et1 = System.currentTimeMillis();

		System.out.println("\n FibonacciRecursively cost time: " + (et1 - st1));

		long st2 = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			System.out.print(FibonacciTailRecursively(i, 0, 1) + " ");
		}
		long et2 = System.currentTimeMillis();
		System.out.println("\n FibonacciRecursively cost time: " + (et2 - st2));
	}
}
