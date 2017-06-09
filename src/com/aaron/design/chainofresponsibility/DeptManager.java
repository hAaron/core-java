package com.aaron.design.chainofresponsibility;

/**
 * 具体处理者(ConcreteHandler)角色：具体处理者接到请求后，可以选择将请求处理掉，
 * 或者将请求传给下家。由于具体处理者持有对下家的引用，因此，
 * 如果需要，具体处理者可以访问下家。
 * 
 * @author Aaron
 * @date 2017年6月9日
 * @version 1.0
 * @package_name com.aaron.design.chainofresponsibility
 */
public class DeptManager extends Handler {

	@Override
	public String handleFeeRequest(String user, double fee) {

		String str = "";
		// 部门经理的权限只能在1000以内
		if (fee < 1000) {
			// 为了测试，简单点，只同意张三的请求
			if ("张三".equals(user)) {
				str = "成功：部门经理同意【" + user + "】的聚餐费用，金额为" + fee + "元";
			} else {
				// 其他人一律不同意
				str = "失败：部门经理不同意【" + user + "】的聚餐费用，金额为" + fee + "元";
			}
		} else {
			// 超过1000，继续传递给级别更高的人处理
			if (getSuccessor() != null) {
				return getSuccessor().handleFeeRequest(user, fee);
			}
		}
		return str;
	}

}
