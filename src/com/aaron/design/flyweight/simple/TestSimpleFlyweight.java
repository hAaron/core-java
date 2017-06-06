package com.aaron.design.flyweight.simple;

/**
 * 虽然客户端申请了三个享元对象，但是实际创建的享元对象只有两个，这就是共享的含义
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.flyweight.simple
 */
public class TestSimpleFlyweight {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlyweightFactory factory = new FlyweightFactory();
		Flyweight fly = factory.factory(new Character('a'));
		fly.operation("First Call");

		fly = factory.factory(new Character('b'));
		fly.operation("Second Call");

		fly = factory.factory(new Character('a'));
		fly.operation("Third Call");
	}
}
