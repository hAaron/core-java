package com.aaron.design.chainofresponsibility;

/**
 * 申请聚餐费用的管理 可以使用责任链模式来实现上述功能：当某人提出聚餐费用申请的请求后， 
 * 该请求会在 项目经理—〉部门经理—〉总经理
 * 这样一条领导处理链上进行传递，发出请求的人并不知道谁会来处理他的请求，每个领导会根据自己的职责范围，
 * 来判断是处理请求还是把请求交给更高级别的领导，只要有领导处理了，传递就结束了。
 * (tomcat中Chain.doFilter 实现)
 * 
 * @author Aaron
 * @date 2017年6月9日
 * @version 1.0
 * @package_name com.aaron.design.chainofresponsibility
 */
public class TestChainOfResponsibility {

	public static void main(String[] args) {
		// 先要组装责任链
		Handler h1 = new GeneralManager();
		Handler h2 = new DeptManager();
		Handler h3 = new ProjectManager();
		h3.setSuccessor(h2);
		h2.setSuccessor(h1);

		// 开始测试
		String test1 = h3.handleFeeRequest("张三", 300);
		System.out.println("test1 = " + test1);
		String test2 = h3.handleFeeRequest("李四", 300);
		System.out.println("test2 = " + test2);
		System.out.println("---------------------------------------");

		String test3 = h3.handleFeeRequest("张三", 700);
		System.out.println("test3 = " + test3);
		String test4 = h3.handleFeeRequest("李四", 700);
		System.out.println("test4 = " + test4);
		System.out.println("---------------------------------------");

		String test5 = h3.handleFeeRequest("张三", 1500);
		System.out.println("test5 = " + test5);
		String test6 = h3.handleFeeRequest("李四", 1500);
		System.out.println("test6 = " + test6);
	}

}