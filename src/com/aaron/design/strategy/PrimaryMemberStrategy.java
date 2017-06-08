package com.aaron.design.strategy;

/**
 * 初级会员折扣类。
 * 具体策略(ConcreteStrategy)角色：包装了相关的算法或行为。
 * 
 * @author Aaron
 * @date 2017年6月8日
 * @version 1.0
 * @package_name com.aaron.design.strategy
 */
public class PrimaryMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("对于初级会员的没有折扣");
		return booksPrice;
	}

}
