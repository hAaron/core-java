package com.aaron.design.strategy;

/**
 * 客户端
 * 
 * @author Aaron
 * @date 2017年6月8日
 * @version 1.0
 * @package_name com.aaron.design.strategy
 */
public class TestStrategy {

	public static void main(String[] args) {
		// 选择并创建需要使用的策略对象
		MemberStrategy strategy = new AdvancedMemberStrategy();
		Price price = new Price(strategy);
		double booksPrice = 100.0;
		booksPrice = price.quote(booksPrice);
		System.out.println("最终价格为：" + booksPrice);
	}

}
