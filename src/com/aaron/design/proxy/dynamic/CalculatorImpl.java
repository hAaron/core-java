package com.aaron.design.proxy.dynamic;

/**
 * 被代理类
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.proxy.dynamic
 */
public class CalculatorImpl implements Calculator {

	@Override
	public int add(int i, int j) {
		return i + j;
	}

	@Override
	public int sub(int i, int j) {
		return i - j;
	}

	@Override
	public int mul(int i, int j) {
		return i * j;
	}

	@Override
	public double div(int i, int j) {
		return i / j;
	}

}
