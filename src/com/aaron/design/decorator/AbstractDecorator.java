package com.aaron.design.decorator;

/**
 * 装饰器抽象类
 * 
 * @author Aaron
 * @date 2017年6月3日
 * @version 1.0
 * @package_name com.aaron.design.decorator
 */
public abstract class AbstractDecorator implements Component {
    private Component component;

    public AbstractDecorator(Component component) {
        this.component = component;
    }

    /**
     * 装饰器抽象类
     */
    @Override
    public void printString(String s) {
        component.printString(s);
    }
}