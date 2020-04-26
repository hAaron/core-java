package com.aaron.design.state;

/**
 * 在线投票系统的应用，要实现控制同一个用户只能投一票，如果一个用户反复投票，
 * 而且投票次数超过5次，则判定为恶意刷票，要取消该用户投票的资格，当然同时也要取消他所投的票；
 * 如果一个用户的投票次数超过8次，将进入黑名单，禁止再登录和使用系统。
 * 要使用状态模式实现，首先需要把投票过程的各种状态定义出来，
 * 根据以上描述大致分为四种状态：正常投票、反复投票、恶意刷票、进入黑名单。然后创建一个投票管理对象（相当于Context）。
 * 
 * 状态的转换基本上都是内部行为，主要在状态模式内部来维护。比如对于投票的人员，
 * 任何时候他的操作都是投票，但是投票管理对象的处理却不一定一样，
 * 会根据投票的次数来判断状态，然后根据状态去选择不同的处理
 * 
 * @author Aaron
 * @date 2017年6月11日
 * @version 1.0
 * @package_name com.aaron.design.state
 */
public class TestState {
	public static void main(String[] args) {
		VoteManager vm = new VoteManager();
		for (int i = 0; i < 15; i++) {
			vm.vote("u1", "A");
		}
	}
}