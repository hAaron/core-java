package com.aaron.util.redis.lock;

import redis.clients.jedis.Jedis;

/**
 * Redis在 2.6.12 版本开始，为 SET 命令增加一系列选项 SET key value[EX seconds][PX * milliseconds][NX|XX] EX seconds: 设定过期时间，单位为秒 PX
 * milliseconds: * 设定过期时间，单位为毫秒 NX: 仅当key不存在时设置值 XX: 仅当key存在时设置值
 * 
 * @author Aaron
 * @date 2019年11月20日
 * @version 1.0
 * @package_type com.aaron.util.redis.lock.Set
 */
public class TryLockWithSet {

    private Jedis jedis = null;

    public boolean tryLock_with_set(String key, String UniqueId, int seconds) {
        boolean flag = false;
        // flag = "OK".equals(jedis.set(key, UniqueId, "NX", "EX", seconds))
        return flag;
    }
}
