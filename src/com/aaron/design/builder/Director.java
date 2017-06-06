package com.aaron.design.builder;

/**
 * 构建者
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.builder
 */
public class Director {

	private Builder builder;

	Director(Builder builder) {
		this.builder = builder;
	}

	public void construct() {
		builder.buildPartA();
		builder.buildPartB();
		builder.buildPartC();
	}

}
