package com.aaron.Thread.lock.lock;

import java.util.concurrent.locks.Lock;

/**
 * 信用卡的用户
 * 
 * @author Aaron
 * @date 2017年6月15日
 * @version 1.0
 * @package_name com.aaron.Thread.lock.lock
 */
public class User implements Runnable {
	private String name; // 用户名
	private MyAccount myAccount; // 所要操作的账户
	private int iocash; // 操作的金额，当然有正负之分了
	private Lock myLock; // 执行操作所需的锁对象

	User(String name, MyAccount myAccount, int iocash, Lock myLock) {
		this.name = name;
		this.myAccount = myAccount;
		this.iocash = iocash;
		this.myLock = myLock;
	}

	@Override
	public void run() {
		// 获取锁
		myLock.lock();
		// 执行现金业务
		System.out.println(name + "正在操作" + myAccount + "账户，金额为" + iocash
				+ "，当前金额为" + myAccount.getCash());
		myAccount.setCash(myAccount.getCash() + iocash);
		System.out.println(name + "操作" + myAccount + "账户成功，金额为" + iocash
				+ "，当前金额为" + myAccount.getCash());
		// 释放锁，否则别的线程没有机会执行了
		myLock.unlock();
	}

}
