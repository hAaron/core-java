package com.aaron.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 创建线程方式3：实现Callable接口（可以获得线程执行后的结果）
 * 
 * @author Aaron
 * @date 2017年6月15日
 * @version 1.0
 * @package_name com.aaron.Thread
 */
public class ImpleCallable {
	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		// 创建一个线程池
		ExecutorService service = Executors.newFixedThreadPool(2);

		// 创建两个有返回值的任务
		MyCallable target1 = new MyCallable("线程1");
		MyCallable target2 = new MyCallable("线程2");

		// 执行任务并获取Future对象
		@SuppressWarnings("unchecked")
		Future future1 = service.submit(target1);
		@SuppressWarnings("unchecked")
		Future future2 = service.submit(target2);

		// 从Future对象上获取任务的返回值，并输出到控制台
		System.out.println("输出-->" + future1.get().toString());
		System.out.println("输出-->" + future2.get().toString());

		// 关闭线程池
		service.shutdown();
	}
}

class MyCallable implements Callable {

	private String name;

	MyCallable(String name) {
		this.name = name;
	}

	@Override
	public Object call() throws Exception {
		// 模拟线程处理
		int i = name.contains("1") ? 10 : (name.contains("2") ? 20 : 0);
		return name + " 返回的结果: " + i;
	}

}