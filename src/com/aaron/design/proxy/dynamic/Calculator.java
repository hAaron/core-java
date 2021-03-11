package com.aaron.design.proxy.dynamic;

/**
 * 实现一个计算器，计算器里面有加减乘除方法， 然后我们实现这个计算的接口，有具体的类和被代理的类， 我们通过动态代理来生成代理类，而不用自己去建了
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.proxy.dynamic
 */
public interface Calculator {

    int add(int i, int j);// 加

    int sub(int i, int j);// 减

    int mul(int i, int j);// 乘

    double div(int i, int j);// 除

}