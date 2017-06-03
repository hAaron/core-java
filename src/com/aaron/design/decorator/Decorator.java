package com.aaron.design.decorator;

/**
 * 装饰器抽象类
 * @author Aaron
 * @date 2017年6月3日
 * @version 1.0
 * @package_name com.aaron.design.decorator
 */
public abstract class Decorator implements Component {
    private Component component;
    public Decorator(Component c) {
        component = c;
    }
    /**
     * 装饰器抽象类
     */
    public void PrintString(String s) {
        component.PrintString(s);
    }
}