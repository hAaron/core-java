package com.aaron.Thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * 
 * @author Aaron
 * @date 2017年6月15日
 * @version 1.0
 * @package_name com.aaron.Thread.pool
 */
class newSingleThreadScheduiedExecutorThread extends Thread {
    private String name;

    newSingleThreadScheduiedExecutorThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " 正在执行...");
    }
}

public class TestNewSingleThreadScheduiedExecutor {

    public static void main(String[] args) {
        // 创建一个单线程执行程序，它可安排在给定延迟后运行命令或者定期地执行。
        ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();

        newSingleThreadScheduiedExecutorThread t1 = new newSingleThreadScheduiedExecutorThread("A");
        newSingleThreadScheduiedExecutorThread t2 = new newSingleThreadScheduiedExecutorThread("B");
        newSingleThreadScheduiedExecutorThread t3 = new newSingleThreadScheduiedExecutorThread("C");
        newSingleThreadScheduiedExecutorThread t4 = new newSingleThreadScheduiedExecutorThread("E");
        newSingleThreadScheduiedExecutorThread t5 = new newSingleThreadScheduiedExecutorThread("D");
        // 将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        // 使用延迟执行风格的方法
        pool.schedule(t4, 10, TimeUnit.MILLISECONDS);
        pool.schedule(t5, 10, TimeUnit.MILLISECONDS);
        // 关闭线程池
        pool.shutdown();
    }

}
