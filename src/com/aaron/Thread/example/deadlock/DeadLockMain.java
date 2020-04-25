package com.aaron.Thread.example.deadlock;

/**
 * 死锁案例
 * 
 * @author Aaron
 * @date 2017年6月14日
 * @version 1.0
 * @package_name com.aaron.Thread.example.deadlock
 */
class LockThreadA implements Runnable {
	private Object objectA;
	private Object objectB;

	LockThreadA(Object objectA, Object objectB) {
		this.objectA = objectA;
		this.objectB = objectB;
	}

	@Override
	public void run() {
		synchronized (objectA) {
			System.out.println("线程LockThreadA 锁住对象objectA。。。。");
			try {
				Thread.sleep(1000);
				synchronized (objectB) {
					System.out.println("执行不到这一步，因为objectB 被线程LockThreadB锁住");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}

class LockThreadB implements Runnable {
	private Object objectA;
	private Object objectB;

	LockThreadB(Object objectA, Object objectB) {
		this.objectA = objectA;
		this.objectB = objectB;
	}

	@Override
	public void run() {
		synchronized (objectB) {
			System.out.println("线程LockThreadB 锁住对象objectB。。。。");
			try {
				Thread.sleep(1000);
				synchronized (objectA) {
					System.out.println("执行不到这一步，因为objectA 被线程LockThreadA锁住");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}

public class DeadLockMain {
	public static void main(String[] args) {
		Object objectA = new Object();
		Object objectB = new Object();

		Thread threadA = new Thread(new LockThreadA(objectA, objectB));
		Thread threadB = new Thread(new LockThreadB(objectA, objectB));
		threadA.start();
		threadB.start();
	}
}
