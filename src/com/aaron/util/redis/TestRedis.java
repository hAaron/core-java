package com.aaron.util.redis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * 
 * @author Aaron
 * @date 2017年5月25日
 * @version 1.0
 * @package_name com.aaron.util.redis
 */
public class TestRedis {

	private Jedis jedis = null;

	@Before
	public void initRedis() {
		jedis = RedisConfig.getJedis();
	}

	@After
	public void clearRedis() {
		RedisConfig.returnResource(jedis);
	}

	// redis操作字符串
	@Test
	public void testString() {
		jedis.set("name", "aaron");
		System.out.println("redis存储字符串：" + jedis.get("name"));

		jedis.append("name", " is my name");// 拼接
		System.out.println("redis拼接字符串：" + jedis.get("name"));

		jedis.del("name"); // 删除某个键
		System.out.println("redis删除字符串：" + jedis.get("name"));

		// 设置多个键值对
		jedis.mset("name", "tom", "age", "23", "tel", "18883455632");
		jedis.incr("age");
		System.out.println("设置多个键值对:" + jedis.get("name") + "-"
				+ jedis.get("age") + "-" + jedis.get("tel"));
	}

	// redis操作Map
	@Test
	public void testMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "aaron");
		map.put("age", "23");
		map.put("email", "123@126.com");
		jedis.hmset("user", map);
		List<String> list = jedis.hmget("user", "name", "age", "email");
		System.out.println("放到redis的map集合，打印出来的是list集合：" + list);
		jedis.hdel("user", "age");// 删除map中的某个键值
		System.out.println(jedis.hmget("user", "age")); // 因为删除了，所以返回的是null
		System.out.println(jedis.hlen("user")); // 返回key为user的键中存放的值的个数2
		System.out.println(jedis.exists("user"));// 是否存在key为user的记录 返回true
		System.out.println(jedis.hkeys("user"));// 返回map对象中的所有key
		System.out.println(jedis.hvals("user"));// 返回map对象中的所有value

		Iterator<String> iterator = jedis.hkeys("user").iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out
					.println("遍历结果集==" + key + ":" + jedis.hmget("user", key));
		}
	}

	// jedis操作List
	@Test
	public void testList() {
		jedis.del("java frameword");
		System.out.println("移除后：" + jedis.lrange("java frameword", 0, -1));
		// 先向key java framework中存放三条数据
		jedis.lpush("java framework", "spring");
		jedis.lpush("java framework", "struts");
		jedis.lpush("java framework", "hibernate");

		// 再取出所有数据jedis.lrange是按范围取出，
		// 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
		System.out.println("取出key为java framework"
				+ jedis.lrange("java framework", 0, -1));

		jedis.del("java framework");
		jedis.rpush("java framework", "spring");
		jedis.rpush("java framework", "struts");
		jedis.rpush("java framework", "hibernate");
		System.out.println(jedis.lrange("java framework", 0, -1));
	}

	// jedis操作Set 
	@Test
	public void testSet() {
		//添加数据
		jedis.sadd("name", "tom");
		jedis.sadd("name", "aaron");
		jedis.sadd("name", "jack");
		jedis.sadd("name", "jeny");
		
		System.out.println("redis中set集合=="+jedis.smembers("name"));
		jedis.srem("name", "jeny");
		System.out.println("移除jeny数据记录后获取所有加入的value=="+jedis.smembers("name"));// 
		System.out.println("判断jeny是否是name集合中的元素=="+jedis.sismember("name", "jeny"));
		System.out.println("随机获取redis中的key为name的数据=="+jedis.srandmember("name"));
		System.out.println("返回集合的元素个数 =="+jedis.scard("name"));
	}
	
	
	
}
