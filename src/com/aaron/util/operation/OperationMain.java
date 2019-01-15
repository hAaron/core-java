package com.aaron.util.operation;

/**
 * 使用运算符实现加、减、乘、除
 * 
 * @author Aaron
 * @date 2019年1月14日
 * @version 1.0
 * @package_type com.aaron.util.operation.OperationMain
 */
public class OperationMain {

	/**
	 * 递归写法
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int add(int num1, int num2) {
		if (num2 == 0)
			return num1;
		int sum = num1 ^ num2;
		int carry = (num1 & num2) << 1;
		return add(sum, carry);
	}

	/**
	 * 迭代写法
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int add1(int num1, int num2) {
		int sum = num1 ^ num2;
		int carry = (num1 & num2) << 1;
		while (carry != 0) {
			int a = sum;
			int b = carry;
			sum = a ^ b;
			carry = (a & b) << 1;
		}
		return sum;
	}

	/**
	 * num1: 减数 num2: 被减数
	 */
	public static int substract(int num1, int num2) {
		int subtractor = add(~num2, 1);// 先求减数的补码（取反加一）
		int result = add(num1, subtractor); // add()即上述加法运算
		return result;
	}

	/**
	 * a: 被乘数 b: 乘数
	 */
	public static int multiply(int a, int b) {
		// 取绝对值
		int multiplicand = a < 0 ? add(~a, 1) : a;
		int multiplier = b < 0 ? add(~b, 1) : b;// 如果为负则取反加一得其补码，即正数
		// 计算绝对值的乘积
		int product = 0;
		int count = 0;
		while (count < multiplier) {
			product = add(product, multiplicand);
			count = add(count, 1);// 这里可别用count++，都说了这里是位运算实现加法
		}
		// 确定乘积的符号
		if ((a ^ b) < 0) {// 只考虑最高位，如果a,b异号，则异或后最高位为1；如果同号，则异或后最高位为0；
			product = add(~product, 1);
		}
		return product;
	}

	public static int multiply2(int a, int b) {
		// 将乘数和被乘数都取绝对值
		int multiplicand = a < 0 ? add(~a, 1) : a;
		int multiplier = b < 0 ? add(~b, 1) : b;

		// 计算绝对值的乘积
		int product = 0;
		while (multiplier > 0) {
			if ((multiplier & 0x1) > 0) {// 每次考察乘数的最后一位
				product = add(product, multiplicand);
			}
			multiplicand = multiplicand << 1;// 每运算一次，被乘数要左移一位
			multiplier = multiplier >> 1;// 每运算一次，乘数要右移一位（可对照上图理解）
		}
		// 计算乘积的符号
		if ((a ^ b) < 0) {
			product = add(~product, 1);
		}
		return product;
	}

	/*
	 * a : 被除数 b : 除数
	 */
	public static int divide(int a, int b) {
		// 先取被除数和除数的绝对值
		int dividend = a > 0 ? a : add(~a, 1);
		int divisor = b > 0 ? a : add(~b, 1);

		int quotient = 0;// 商
		int remainder = 0;// 余数
		// 不断用除数去减被除数，直到被除数小于被除数（即除不尽了）
		while (dividend >= divisor) {// 直到商小于被除数
			quotient = add(quotient, 1);
			dividend = substract(dividend, divisor);
		}
		// 确定商的符号
		if ((a ^ b) < 0) {// 如果除数和被除数异号，则商为负数
			quotient = add(~quotient, 1);
		}
		// 确定余数符号
		remainder = b > 0 ? dividend : add(~dividend, 1);
		return quotient;// 返回商
	}

	public static int divide_v2(int a, int b) {
		// 先取被除数和除数的绝对值
		int dividend = a > 0 ? a : add(~a, 1);
		int divisor = b > 0 ? a : add(~b, 1);
		int quotient = 0;// 商
		int remainder = 0;// 余数
		for (int i = 31; i >= 0; i--) {
			// 比较dividend是否大于divisor的(1<<i)次方，不要将dividend与(divisor<<i)比较，而是用(dividend>>i)与divisor比较，
			// 效果一样，但是可以避免因(divisor<<i)操作可能导致的溢出，如果溢出则会可能dividend本身小于divisor，但是溢出导致dividend大于divisor
			if ((dividend >> i) >= divisor) {
				quotient = add(quotient, 1 << i);
				dividend = substract(dividend, divisor << i);
			}
		}
		// 确定商的符号
		if ((a ^ b) < 0) {
			// 如果除数和被除数异号，则商为负数
			quotient = add(~quotient, 1);
		}
		// 确定余数符号
		remainder = b > 0 ? dividend : add(~dividend, 1);
		return quotient;// 返回商
	}

	public static void main(String[] args) {
		System.out.println(add(10, 3));
		System.out.println(add1(10, 3));

		System.out.println(substract(10, 3));
		System.out.println(multiply(10, 3));

		System.out.println(divide(10, 3));
		System.out.println(divide_v2(10, 3));
	}

}
