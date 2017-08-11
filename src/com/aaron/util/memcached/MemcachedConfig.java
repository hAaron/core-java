package com.aaron.util.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

/**
 * memcached 连接配置
 * 
 * @author Aaron
 * @date 2017年8月11日
 * @version 1.0
 * @package_name com.aaron.util.memcached
 */
public class MemcachedConfig {
	private static final String host = "127.0.0.1"; // redis所在IP地址
	private static final int port = 11211; // 端口号
	static MemcachedClient client = null;

	/**
	 * 初始化MemcachedClient 客户端
	 */
	static {
		try {
			// 连接Memcached 本地服务
			client = new MemcachedClient(new InetSocketAddress(host, port));
			System.out.println("MemcachedClient客户端连接成功！");
		} catch (IOException e) {
			System.out.println("MemcachedClient客户端连接失败！");
			e.printStackTrace();
		}
	}

	/**
	 * 关闭客户端
	 * 
	 * @param client
	 */
	public static void shutDown(MemcachedClient client) {
		if (client != null) {
			client.shutdown();
		}
	}

}
