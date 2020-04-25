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
public class ProjectManager extends Handler {

	@Override
	public String handleFeeRequest(String user, double fee) {
		String str = "";
		// 项目经理权限比较小，只能在500以内
		if (fee < 500) {
			// 为了测试，简单点，只同意张三的请求
			if ("张三".equals(user)) {
				str = "成功：项目经理同意【" + user + "】的聚餐费用，金额为" + fee + "元";
			} else {
				// 其他人一律不同意
				str = "失败：项目经理不同意【" + user + "】的聚餐费用，金额为" + fee + "元";
			}
		} else {
			// 超过500，继续传递给级别更高的人处理
			if (getSuccessor() != null) {
				return getSuccessor().handleFeeRequest(user, fee);
			}
		}
		return str;
	}

}
