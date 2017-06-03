package com.aaron.design.decorator;

import java.io.*;

/**
 * 具体被装饰类
 * 
 * @author Aaron
 * @date 2017年6月3日
 * @version 1.0
 * @package_name com.aaron.design.decorator
 */
public class ConcreteComponent implements Component {
	public ConcreteComponent() {
	}

	public void PrintString(String s) {
		System.out.println("Input String is:" + s);
	}
}