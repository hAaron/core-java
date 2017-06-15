package com.aaron.Thread.lock.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock实现提供了比使用synchronized方法和语句可获得的更广泛的锁定操作。
 * 
 * @author Aaron
 * @date 2017年6月15日
 * @version 1.0
 * @package_name com.aaron.Thread.lock
 */
public class LockClient {
	public static void main(String[] args) {
		// 创建并发访问的账户
		MyAccount myAccount = new MyAccount("95599200901215522", 10000);
		// 创建一个锁对象
		Lock lock = new ReentrantLock();
		// 创建一个线程池
		ExecutorService pool = Executors.newCachedThreadPool();
		// 创建一些并发访问用户，一个信用卡，存的存，取的取，好热闹啊
		User u1 = new User("张三", myAccount, -4000, lock);
		User u2 = new User("张三他爹", myAccount, 6000, lock);
		User u3 = new User("张三他弟", myAccount, -8000, lock);
		User u4 = new User("张三", myAccount, 800, lock);
		// 在线程池中执行各个用户的操作
		pool.execute(u1);
		pool.execute(u2);
		pool.execute(u3);
		pool.execute(u4);
		// 关闭线程池
		pool.shutdown();
	}
}
