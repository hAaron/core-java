package com.aaron.concurrent.c8;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Semaphore Demo
 * 
 * @author huangbo
 * @date 2021/12/31
 */
public class SemaphoreDemo {

    // 停车场同时容纳的车辆10
    private static Semaphore semaphore = new Semaphore(10);

    // 模拟100辆车进入停车场
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("====" + Thread.currentThread().getName() + "来到停车场");
                        if (semaphore.availablePermits() == 0) {
                            System.out.println("车位不足，请耐心等待");
                        }
                        semaphore.acquire();// 获取令牌尝试进入停车场
                        System.out.println(Thread.currentThread().getName() + "成功进入停车场");
                        Thread.sleep(new Random().nextInt(10000));// 模拟车辆在停车场停留的时间
                        System.out.println(Thread.currentThread().getName() + "驶出停车场");
                        semaphore.release();// 释放令牌，腾出停车场车位
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, i + "号车");
            thread.start();
        }
    }
}
