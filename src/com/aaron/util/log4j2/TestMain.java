package com.aaron.util.log4j2;

/**
 * 测试log4j2异步日志打印（需要导入log4j2 jar包 Jar.java）
 * 
 * log4j2.xml 日志文件配置详细在笔记里
 * 
 * @author Aaron
 * @date 2018年4月12日
 * @version 1.0
 * @package_type com.aaron.util.log4j2.TestMain
 */
public class TestMain {

	// private static final Logger LOG = LogManager.getLogger(TestMain.class);
	//
	// private static String[] INFO = {
	// "test info test info test info test info test info test info test info test
	// info test info test info test info test info test info test info test info
	// test info",
	// "test debug test debug test debug test debug test debug test debug test debug
	// test debug test debug test debug test debug test debug test debug test debug
	// test debug",
	// " test error test error test error test error test error test error test
	// error test error test error test error test error test error test error test
	// error test error test error",
	// " test warn test warn test warn test warn test warn test warn test warn test
	// warn test warn test warn test warn test warn test warn test warn test warn
	// test warn test warn test warn test warn test warn" };
	//
	// final static CountDownLatch l = new CountDownLatch(100);
	//
	// public static void main(String[] agrs) {
	//
	// test1();
	// }
	//
	// /**
	// * 多线程
	// */
	// public static void test1() {
	// int count = 100;
	// long begin = System.currentTimeMillis();
	// for (int i = 0; i < count; ++i) {
	// new Thread(new Runnable() {
	// @Override
	// public void run() {
	// for (int i = 0; i < 10000; i++) {
	// LOG.info("[" + Thread.currentThread().getName() + ","
	// + i + "]" + INFO[i % 4]
	// + System.currentTimeMillis());
	// }
	// l.countDown();
	// }
	// }).start();
	// }
	// try {
	// System.out.println("waiting");
	// l.await();
	// LOG.info("FINISH. COST : " + (System.currentTimeMillis() - begin));
	// System.out.println("finishing:"
	// + ((System.currentTimeMillis() - begin) * 0.001f) + "s");
	// } catch (InterruptedException e) {
	// LOG.error("ERROR");
	// }
	//
	// }
	//
	// /**
	// * 单线程
	// */
	// public static void test2() {
	//
	// long begin = System.currentTimeMillis();
	// for (int i = 0; i < 5000000; i++) {
	// LOG.info("[" + Thread.currentThread().getName() + "," + i + "]"
	// + INFO[i % 4] + System.currentTimeMillis());
	// }
	// System.out.println("waiting");
	// LOG.info("FINISH. COST : " + (System.currentTimeMillis() - begin));
	// System.out.println("finishing:"
	// + ((System.currentTimeMillis() - begin) * 0.001f) + "s");
	//
	// }

}
