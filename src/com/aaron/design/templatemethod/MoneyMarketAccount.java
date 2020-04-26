package com.aaron.design.templatemethod;

/**
 * 具体模板角色类 具体模板(Concrete Template)角色又如下责任： 
 * 实现父类所定义的一个或多个抽象方法，它们是一个顶级逻辑的组成步骤。
 * 每一个抽象模板角色都可以有任意多个具体模板角色与之对应，而每一个具体模板角色都可以给出这些抽象方法（也就是顶级逻辑的组成步骤）的不同实现，从而使得顶级逻辑的实现各不相同。
 * 
 * @author Aaron
 * @date 2017年6月8日
 * @version 1.0
 * @package_name com.aaron.design.templatemethod
 */
public class MoneyMarketAccount extends AbstractAccount {

	@Override
	protected String doCalculateAccountType() {
		return "货币市场账号";
	}

	@Override
	protected double doCalculateInterestRate() {
		return 0.045;
	}

}
