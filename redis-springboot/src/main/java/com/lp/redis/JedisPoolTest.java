package com.lp.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {
    public static void main(String[] args) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(200);

        String age;
        JedisPool jedisPool = new JedisPool(poolConfig,"10.0.1.255", 6379);
        Jedis jedis = jedisPool.getResource();

        age = jedis.get("age");
        System.out.println("age=" + age);


        age = jedis.set("age", "12");
        System.out.println("age=" + age);

        age = jedis.get("age");
        System.out.println("age=" + age);

        jedis.close();
    }
}
