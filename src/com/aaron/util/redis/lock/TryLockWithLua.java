package com.aaron.util.redis.lock;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;

/**
 * redis实现分布式锁2：使用Lua脚本（包含setnx和expire两条指令）
 * 
 * @author Aaron
 * @date 2019年11月20日
 * @version 1.0
 * @package_type com.aaron.util.redis.lock.Lua
 */
public class TryLockWithLua {

    private Jedis jedis = null;

    public boolean tryLock_with_lua(String key, String UniqueId, int seconds) {
        String lua_scripts = "if redis.call('setnx',KEYS[1],ARGV[1]) == 1 then"
            + "redis.call('expire',KEYS[1],ARGV[2]) return 1 else return 0 end";
        List<String> keys = new ArrayList<>();
        List<String> values = new ArrayList<>();
        keys.add(key);
        values.add(UniqueId);
        values.add(String.valueOf(seconds));
        Object result = jedis.eval(lua_scripts, keys, values);
        // 判断是否成功
        return result.equals(1L);
    }
}
