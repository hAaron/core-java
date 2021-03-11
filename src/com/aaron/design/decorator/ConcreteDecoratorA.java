package com.aaron.design.decorator;

/**
 * 具体的装饰器类： ConcreteDecorator， 具体装饰器类实现真正的动态添加类的功能的作用
 * 
 * @author Aaron
 * @date 2017年6月3日
 * @version 1.0
 * @package_name com.aaron.design.decorator
 */
public class ConcreteDecoratorA extends AbstractDecorator {
    public ConcreteDecoratorA(Component c) {
        super(c);
    }

    /**
     * 具体的装饰器类
     */
    @Override
    public void printString(String s) {
        super.printString(s);
        printStringLen(s);
    }

    /**
     * 额外扩展的方法
     * 
     * @param s
     */
    public void printStringLen(String string) {
        System.out.println("额外扩展的方法###The length of string is:" + string.length());
    }
}