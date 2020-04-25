package com.aaron.design.builder;

/**
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.builder
 */
public interface Builder {
	void buildPartA();

	void buildPartB();

	void buildPartC();

	Product getResult();
}
