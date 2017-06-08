package com.aaron.design.templatemethod;

/**
 * 具体模板角色类
 * 
 * @author Aaron
 * @date 2017年6月8日
 * @version 1.0
 * @package_name com.aaron.design.templatemethod
 */
public class CDAccount extends Account {

	@Override
	protected String doCalculateAccountType() {
		return "定期账号";
	}

	@Override
	protected double doCalculateInterestRate() {
		return 0.06;
	}

}