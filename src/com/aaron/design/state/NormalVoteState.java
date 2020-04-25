package com.aaron.design.state;

/**
 * 具体状态类——正常投票 
 * 具体状态(ConcreteState)角色：每一个具体状态类都实现了环境（Context）的一个状态所对应的行为。
 * 
 * @author Aaron
 * @date 2017年6月11日
 * @version 1.0
 * @package_name com.aaron.design.state
 */
public class NormalVoteState implements VoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		// 正常投票，记录到投票记录中
		voteManager.getMapVote().put(user, voteItem);
		System.out.println("恭喜投票成功");
	}

}
