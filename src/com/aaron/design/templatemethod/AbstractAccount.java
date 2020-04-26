package com.aaron.design.templatemethod;

/**
 * 抽象模板角色类 抽象模板(Abstract Template)角色有如下责任： 模板方法就是通过把不变的行为移到超类，去除子类重复的代码
 * 定义了一个或多个抽象操作，以便让子类实现。这些抽象操作叫做基本操作，它们是一个顶级逻辑的组成步骤。
 * 定义并实现了一个模板方法。这个模板方法一般是一个具体方法，它给出了一个顶级逻辑的骨架，而逻辑的组成步骤在相应的抽象操作中，推迟到子类实现。顶级逻辑也有可能调用一些具体方法。
 * 
 * @author Aaron
 * @date 2017年6月8日
 * @version 1.0
 * @package_name com.aaron.design.templatemethod
 */
public abstract class AbstractAccount {
	/**
	 * 模板方法，计算利息数额
	 * 
	 * @return 返回利息数额
	 */
	public final double calculateInterest() {
		double interestRate = doCalculateInterestRate();
		String accountType = doCalculateAccountType();
		double amount = calculateAmount(accountType);
		return amount * interestRate;
	}

	/**
	 * 基本方法留给子类实现
	 * 
	 * @return
	 */
	protected abstract String doCalculateAccountType();

	/**
	 * 基本方法留给子类实现
	 * 
	 * @return
	 */
	protected abstract double doCalculateInterestRate();

	/**
	 * 基本方法，已经实现
	 * 
	 * @param accountType
	 * @return
	 */
	private double calculateAmount(String accountType) {
		/**
		 * 省略相关的业务逻辑
		 */
		System.out.println("accountType:" + accountType);
		return 7243.00;
	}
}