package com.aaron.design.state;

/**
 * 具体状态类——恶意投票
 * 具体状态(ConcreteState)角色：每一个具体状态类都实现了环境（Context）的一个状态所对应的行为。
 * 
 * @author Aaron
 * @date 2017年6月11日
 * @version 1.0
 * @package_name com.aaron.design.state
 */
public class SpiteVoteState implements VoteState{

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		// 恶意投票，取消用户的投票资格，并取消投票记录
        String str = voteManager.getMapVote().get(user);
        if(str != null){
            voteManager.getMapVote().remove(user);
        }
        System.out.println("你有恶意刷屏行为，取消投票资格");
	}

}
