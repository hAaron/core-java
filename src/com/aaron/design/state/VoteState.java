package com.aaron.design.state;

/**
 * 抽象状态类
 * 抽象状态(State)角色：定义一个接口，用以封装环境（Context）对象的一个特定的状态所对应的行为。
 * 
 * @author Aaron
 * @date 2017年6月11日
 * @version 1.0
 * @package_name com.aaron.design.state
 */
public interface VoteState {
	/**
	 * 处理状态对应的行为
	 * 
	 * @param user
	 *            投票人
	 * @param voteItem
	 *            投票项
	 * @param voteManager
	 *            投票上下文，用来在实现状态对应的功能处理的时候， 可以回调上下文的数据
	 */
	public void vote(String user, String voteItem, VoteManager voteManager);
}
