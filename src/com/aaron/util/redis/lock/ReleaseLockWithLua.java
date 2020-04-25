package com.aaron.util.redis.lock;

import java.util.Collections;

import redis.clients.jedis.Jedis;

/**
 * 释放锁时需要验证value值，也就是说我们在获取锁的时候需要设置一个value，不能直接用del key这种粗暴的方式， 因为直接del
 * key任何客户端都可以进行解锁了，所以解锁时，我们需要判断锁是否是自己的，基于value值来判断
 * 
 * @author Aaron
 * @date 2019年11月20日
 * @version 1.0
 * @package_type com.aaron.util.redis.lock.ReleaseLockWithLua
 */
public class ReleaseLockWithLua {

	private Jedis jedis = null;

	public boolean releaseLock_with_lua(String key, String value) {
		String luaScript = "if redis.call('get',KEYS[1]) == ARGV[1] then "
				+ "return redis.call('del',KEYS[1]) else return 0 end";
		return jedis.eval(luaScript, Collections.singletonList(key), Collections.singletonList(value)).equals(1L);
	}

}
