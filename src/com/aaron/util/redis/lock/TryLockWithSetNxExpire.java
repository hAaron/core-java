package com.aaron.util.redis.lock;

import redis.clients.jedis.Jedis;

/**
 * redis实现分布式锁1：利用setnx+expire命令
 * 错误的做法--setnx和expire是分开的两步操作，不具有原子性，如果执行完第一条指令应用异常或者重启了，锁将无法过期
 * 
 * @author Aaron
 * @date 2019年11月20日
 * @version 1.0
 * @package_type com.aaron.util.redis.lock.SetNxExpire
 */
public class TryLockWithSetNxExpire {
	private Jedis jedis = null;

	public boolean tryLock(String key, String requset, int timeout) {
		Long result = jedis.setnx(key, requset);
		// result = 1时，设置成功，否则设置失败
		if (result == 1L) {
			return jedis.expire(key, timeout) == 1L;
		} else {
			return false;
		}
	}
}
