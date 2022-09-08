package com.aaron.concurrent.c8;

import java.util.concurrent.CountDownLatch;

/**
 * @author huangbo
 * @date 2021/12/31
 */
public class CountDownLatchDemo2 extends Thread {
    // 运动员达起点过程
    private CountDownLatch comingTag;
    // 运动员等待裁判准备信号
    private CountDownLatch waitTag;
    // 运动员等待裁判起跑信号
    private CountDownLatch waitRunTag;
    // 运动员等待裁判说起跑
    private CountDownLatch beginTag;
    // 运动员到达终点
    private CountDownLatch endTag;

    public CountDownLatchDemo2(CountDownLatch comingTag, CountDownLatch waitTag, CountDownLatch waitRunTag,
        CountDownLatch beginTag, CountDownLatch endTag) {
        super();
        this.comingTag = comingTag;
        this.waitTag = waitTag;
        this.waitRunTag = waitRunTag;
        this.beginTag = beginTag;
        this.endTag = endTag;
    }

    /**
     * 裁判端
     *
     * @param args
     */
    public static void main(String[] args) {
        CountDownLatch comintTag = new CountDownLatch(10);
        CountDownLatch waitTag = new CountDownLatch(1);
        CountDownLatch waitRunTag = new CountDownLatch(10);
        CountDownLatch beginTag = new CountDownLatch(1);
        CountDownLatch endTag = new CountDownLatch(10);

        CountDownLatchDemo2[] CountDownLatchDemo2s = new CountDownLatchDemo2[10];
        for (int i = 0; i < 10; i++) {
            CountDownLatchDemo2s[i] = new CountDownLatchDemo2(comintTag, waitTag, waitRunTag, beginTag, endTag);
            CountDownLatchDemo2s[i].start();
        }

        try {
            System.out.println("裁判等待所有运动员到场");
            comintTag.await();

            // 裁判发起准备信号
            System.out.println("裁判发起准备信号");
            waitTag.countDown();

            System.out.println("裁判检查等待所有人准备完成");
            waitRunTag.await();

            System.out.println("裁判发起起跑信号--------------");
            beginTag.countDown();

            endTag.await();
            System.out.println("所有运动员到达终点，比赛结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("运动员" + Thread.currentThread().getName() + "正在骑车赶到起点");
        try {
            Thread.sleep(2000);
            System.out.println("运动员" + Thread.currentThread().getName() + "到达起点,等待准备");
            comingTag.countDown();

            waitTag.await();

            System.out.println("运动员" + Thread.currentThread().getName() + "正在准备……");
            Thread.sleep(1000);

            waitRunTag.countDown();

            // 等待裁判起跑信号
            beginTag.await();

            System.out.println("运动员" + Thread.currentThread().getName() + "到达终点******");
            endTag.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
