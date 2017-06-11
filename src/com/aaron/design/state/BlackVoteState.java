package com.aaron.design.state;

/**
 * 具体状态类——黑名单
 * 具体状态(ConcreteState)角色：每一个具体状态类都实现了环境（Context）的一个状态所对应的行为。
 * 
 * @author Aaron
 * @date 2017年6月11日
 * @version 1.0
 * @package_name com.aaron.design.state
 */
public class BlackVoteState implements VoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		// 记录黑名单中，禁止登录系统
		System.out.println("进入黑名单，将禁止登录和使用本系统");
	}

}
