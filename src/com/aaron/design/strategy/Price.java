package com.aaron.design.strategy;

/**
 * 环境(Context)角色：持有一个Strategy的引用。
 * 
 * @author Aaron
 * @date 2017年6月8日
 * @version 1.0
 * @package_name com.aaron.design.strategy
 */
public class Price {
	/**
	 * 持有一个具体的策略对象
	 */
	private MemberStrategy strategy;

	/**
	 * 构造函数，传入一个具体的策略对象
	 * 
	 * @param strategy
	 *            具体的策略对象
	 */
	public Price(MemberStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * 计算图书的价格
	 * 
	 * @param booksPrice
	 *            图书的原价
	 * @return 计算出打折后的价格
	 */
	public double quote(double booksPrice) {
		return strategy.calcPrice(booksPrice);
	}

}
