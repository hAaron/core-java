package com.aaron.design.strategy;

/**
 * 抽象策略(Strategy)角色：这是一个抽象角色，通常由一个接口或抽象类实现。此角色给出所有的具体策略类所需的接口。
 * 
 * @author Aaron
 * @date 2017年6月8日
 * @version 1.0
 * @package_name com.aaron.design.strategy
 */
public interface MemberStrategy {

    /**
     * 计算图书的价格
     * 
     * @param booksPrice
     *            图书的原价
     * @return 计算出打折后的价格
     */
    public double calcPrice(double booksPrice);

}
