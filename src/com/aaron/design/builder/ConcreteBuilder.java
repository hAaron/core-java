package com.aaron.design.builder;

/**
 * 具体建造工具
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.builder
 */
public class ConcreteBuilder implements Builder {
	Part partA, partB, partC;

	@Override
	public void buildPartA() {
		System.out.println("这里是具体如何构建partA的代码");
	}

	@Override
	public void buildPartB() {
		System.out.println("这里是具体如何构建partB的代码");
	}

	@Override
	public void buildPartC() {
		System.out.println("这里是具体如何构建partC的代码");
	}

	@Override
	public Product getResult() {
		System.out.println("返回最后组装成品结果");
		return null;
	}
}