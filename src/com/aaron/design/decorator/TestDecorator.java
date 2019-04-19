package com.aaron.design.decorator;

/**
 * 意图：在运行时组合操作的新变化。通过装饰器模式可以在运行时扩充一个类的功能。增加一个修饰类包裹原来的类，</br>
 * 包裹的方式一般是通过在将原来的对象作为修饰类的构造函数的参数。</br>
 * 装饰类实现新的功能，但是，在不需要用到新功能的地方，它可以直接调用原来的类中的方法。</br> 
 * 修饰类必须和原来的类有相同的接口。
 * 
 * @author Aaron
 * @date 2017年6月3日
 * @version 1.0
 * @package_name com.aaron.design.decorator
 */
public class TestDecorator {
	
	public static void main(String[] args) {
		Component component = new ConcreteComponent();
		ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA(component);
		concreteDecoratorA.printString("hello world");
	}

}
