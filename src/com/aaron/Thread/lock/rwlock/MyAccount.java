package com.aaron.Thread.lock.rwlock;

/**
 * 信用卡账户
 * 
 * @author Aaron
 * @date 2017年6月15日
 * @version 1.0
 * @package_name com.aaron.Thread.lock.lock
 */
class MyAccount {

	private String id; // 账号
	private int cash; // 账户余额

	public MyAccount(String id, int cash) {
		this.id = id;
		this.cash = cash;
	}

	public MyAccount() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	@Override
	public String toString() {
		return "MyAccount [账号id=" + id + ", 余额cash=" + cash + "]";
	}
}
