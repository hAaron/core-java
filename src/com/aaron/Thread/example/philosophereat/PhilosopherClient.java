package com.aaron.Thread.example.philosophereat;

/**
 * 哲学家就餐问题
 * 
 * 问题描述：一圆桌前坐着5位哲学家，两个人中间有一只筷子，桌子中央有面条。哲学家思考问题， 当饿了的时候拿起左右两只筷子吃饭，必须拿到两只筷子才能吃饭。
 * 上述问题会产生死锁的情况，当5个哲学家都拿起自己右手边的筷子，准备拿左手边的筷子时产生死锁现象。
 * 
 * @author Aaron
 * @date 2017年6月14日
 * @version 1.0
 * @package_name com.aaron.Thread.example.philosophereat
 */
class Philosopher extends Thread {
	private String name;
	private Chopstick chopstick;

	Philosopher(String name, Chopstick chopstick) {
		this.name = name;
		this.chopstick = chopstick;
	}

	@Override
	public void run() {
		while (true) {
			thinking();
			chopstick.takeChopstick(name);
			eating();
			chopstick.putChopstick(name);
		}
	}

	public void eating() {
		System.out.println(name+" 正在吃饭。");
		try {
			sleep(1000);// 模拟吃饭，占用一段时间资源
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void thinking() {
		System.out.println(name+" 正在思考。");
		try {
			sleep(1000);// 模拟思考
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Chopstick {
	/* 5只筷子，初始为都未被用 */
	private boolean[] used = { false, false, false, false, false, false };

	/* 只有当左右手的筷子都未被使用时，才允许获取筷子，且必须同时获取左右手筷子 */
	public synchronized void takeChopstick(String name) {
		
		int i = name.contains("A") ? 0 : (name.contains("B") ? 1 : (name
				.contains("C") ? 2 : (name.contains("D") ? 3 : (name
				.contains("E") ? 4 : -1))));
		while (used[i] || used[(i + 1) % 5]) {
			try {
				wait();// 如果左右手有一只正被使用，等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name+" 同时获取左右手筷子。");
		used[i] = true;
		used[(i + 1) % 5] = true;
	}

	/* 必须同时释放左右手的筷子 */
	public synchronized void putChopstick(String name) {
		int i = name.contains("A") ? 0 : (name.contains("B") ? 1 : (name
				.contains("C") ? 2 : (name.contains("D") ? 3 : (name
				.contains("E") ? 4 : -1))));// Integer.parseInt(name);
		used[i] = false;
		used[(i + 1) % 5] = false;
		System.out.println(name+" 同时释放左右手的筷子");
		notifyAll();// 唤醒其他线程
	}
}

public class PhilosopherClient {
	public static void main(String[] args) {
		Chopstick chopstick = new Chopstick();
		Philosopher philosopherA = new Philosopher("哲学家philosopherA", chopstick);
		Philosopher philosopherB = new Philosopher("哲学家philosopherB", chopstick);
		Philosopher philosopherC = new Philosopher("哲学家philosopherC", chopstick);
		Philosopher philosopherD = new Philosopher("哲学家philosopherD", chopstick);
		Philosopher philosopherE = new Philosopher("哲学家philosopherE", chopstick);
		philosopherA.start();
		philosopherB.start();
		philosopherC.start();
		philosopherD.start();
		philosopherE.start();
	}
}
