package com.aaron.util.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

/**
 * memcached java常用方法测试
 * 
 * @author Aaron
 * @date 2017年8月11日
 * @version 1.0
 * @package_name com.aaron.util.memcached
 */
public class MemcachedTest {

	public static void main(String[] args) throws IOException, Exception,
			ExecutionException {
		MemcachedClient client = MemcachedConfig.client;
		// setMemcached(client);
		// addMemcached(client);
		// replaceMemcached(client);
		// appendMemcached(client);
		// prependMemcached(client);
		// CASMemcached(client);
		// getMemcached(client);
		// getsCASMemcached(client);

		// deleteMemcached(client);

		incrDecrMemcached(client);

		MemcachedConfig.shutDown(client);
	}

	/**
	 * 自增自减操作
	 * 
	 * @param client
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void incrDecrMemcached(MemcachedClient client)
			throws InterruptedException, ExecutionException {
		// 添加数字值
		Future fo = client.set("number", 900, "1000");

		// 输出执行 set 方法后的状态
		System.out.println("set status:" + fo.get());

		// 获取键对应的值
		System.out.println("value in cache - " + client.get("number"));

		// 自增并输出
		System.out.println("value in cache after increment - "
				+ client.incr("number", 111));

		// 自减并输出
		System.out.println("value in cache after decrement - "
				+ client.decr("number", 112));
	}

	/**
	 * 删除key对应的value值
	 * 
	 * @param client
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void deleteMemcached(MemcachedClient client)
			throws InterruptedException, ExecutionException {
		// 添加数据
		Future fo = client.set("keys", 900,
				"World's largest online tutorials library");

		// 输出执行 set 方法后的状态
		System.out.println("set status:" + fo.get());

		// 获取键对应的值
		System.out.println("keys value in cache - " + client.get("keys"));

		// 对存在的key进行数据添加操作
		Future fo1 = client.delete("keys");

		// 输出执行 delete 方法后的状态
		System.out.println("delete status:" + fo1.get());

		// 获取键对应的值
		System.out.println("keys value in cache - "
				+ client.get("codingground"));
	}

	/**
	 * 通过 gets 方法获取 CAS token（令牌）
	 * 
	 * @param client
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void getsCASMemcached(MemcachedClient client)
			throws InterruptedException, ExecutionException {
		// 添加数据
		Future fo = client.set("keys", 900, "Free Education");

		// 输出执行 set 方法后的状态
		System.out.println("set status:" + fo.get());

		// 从缓存中获取键为 keys 的值
		System.out.println("keys value in cache - " + client.get("keys"));

		// 通过 gets 方法获取 CAS token（令牌）
		CASValue casValue = client.gets("keys");

		// 输出 CAS token（令牌） 值
		System.out.println("CAS value in cache - " + casValue);
	}

	/**
	 * 使用 get 方法获取数据
	 * 
	 * @param client
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void getMemcached(MemcachedClient client)
			throws InterruptedException, ExecutionException {
		// 添加数据
		Future fo = client.set("keys", 900, "Free Education");

		// 输出执行 set 方法后的状态
		System.out.println("set status:" + fo.get());

		// 使用 get 方法获取数据
		System.out.println("keys value in cache - " + client.get("keys"));
	}

	/**
	 * 尝试使用cas方法来更新数据
	 * 
	 * @param client
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void CASMemcached(MemcachedClient client)
			throws InterruptedException, ExecutionException {
		// 添加数据
		Future fo = client.set("keys", 900, "values");

		// 输出执行set方法后的状态
		System.out.println("set status:" + fo.get());
		// 使用 get 方法获取数据
		System.out.println("keys value in cache - " + client.get("keys"));
		// 通过 gets 方法获取 CAS token（令牌）
		CASValue casValue = client.gets("keys");

		// 输出 CAS token（令牌） 值
		System.out.println("CAS token - " + casValue);

		// 尝试使用cas方法来更新数据
		CASResponse casresp = client.cas("keys", casValue.getCas(), 900,
				"Largest Tutorials-Library");

		// 输出 CAS 响应信息
		System.out.println("CAS Response - " + casresp);

		// 输出值
		System.out.println("keys value in cache - " + client.get("keys"));
	}

	/**
	 * 对存在的key进行数据添加操作
	 * 
	 * @param client
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void prependMemcached(MemcachedClient client)
			throws InterruptedException, ExecutionException {
		// 添加数据
		Future fo = client.set("keys", 900, "Education for All");

		// 输出执行 set 方法后的状态
		System.out.println("set status:" + fo.get());

		// 获取键对应的值
		System.out.println("keys value in cache - " + client.get("keys"));

		// 对存在的key进行数据添加操作
		Future fo1 = client.prepend("keys", "Free ");

		// 输出执行 set 方法后的状态
		System.out.println("prepend status:" + fo1.get());

		// 获取键对应的值
		System.out.println("keys value in cache - " + client.get("keys"));
	}

	/**
	 * 对存在的key进行数据添加操作
	 * 
	 * @param client
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void appendMemcached(MemcachedClient client)
			throws InterruptedException, ExecutionException {
		getMemcached(client);

		// 对存在的key进行数据添加操作
		Future fo1 = client.append("keys", " for All");

		// 输出执行 set 方法后的状态
		System.out.println("append status:" + fo1.get());

		// 获取键对应的值
		System.out.println("keys value in cache - " + client.get("keys"));
	}

	/**
	 * 替换Memcached缓存中value值
	 * 
	 * @param client
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void replaceMemcached(MemcachedClient client)
			throws InterruptedException, ExecutionException {
		// 添加第一个 key=》value 对
		Future fo = client.set("keys", 900, "before replace");

		// 输出执行 add 方法后的状态
		System.out.println("add status:" + fo.get());

		// 获取键对应的值
		System.out.println("keys value in cache - " + client.get("keys"));

		// 添加新的 key
		fo = client.replace("keys", 900, "after replace");

		// 输出执行 set 方法后的状态
		System.out.println("replace status:" + fo.get());

		// 获取键对应的值
		System.out.println("keys value in cache - " + client.get("keys"));
	}

	/**
	 * 向Memcached缓存中添加key-value值
	 * 
	 * @param client
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void addMemcached(MemcachedClient client)
			throws InterruptedException, ExecutionException {
		// 添加数据
		Future<Boolean> future = client.set("keyAdd", 900, "valueAdd");
		// 打印状态
		System.out.println("set status:" + future.get());
		// 输出
		System.out.println("keyAdd's value in cache - " + client.get("keyAdd"));

		// 添加
		Future<Boolean> future2 = client.add("keyAdd", 900, "memcached");
		// 打印状态
		System.out.println("set status:" + future2.get());
		// 输出
		System.out.println("keyAdd's value in cache - " + client.get("keyAdd"));
		// 添加新key
		future2 = client.add("codingground", 900, "All Free Compilers");
		// 打印状态
		System.out.println("add status:" + future2.get());
		// 输出
		System.out.println("codingground value in cache - "
				+ client.get("codingground"));
	}

	/**
	 * 向Memcached缓存中赋值
	 * 
	 * @param client
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void setMemcached(MemcachedClient client)
			throws InterruptedException, ExecutionException {
		// 存储数据
		Future<Boolean> fo = client.set("key", 900, "value");
		// 查看存储状态
		System.out.println("set status:" + fo.get());
		// 输出值
		System.out.println("key's value in cache - " + client.get("key"));
	}
}
