package com.lp.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

public class JedisTest {
    public static void main(String[] args) {
        String age;
//        Jedis jedis = new Jedis("10.0.1.255", 6379);
        //带密码
        JedisShardInfo shardInfo = new JedisShardInfo("10.0.1.255", 6379);
        shardInfo.setPassword("123456");
        Jedis jedis = new Jedis(shardInfo);
        age = jedis.get("age");
        System.out.println("age=" + age);


        age = jedis.set("age", "17");
        System.out.println("age=" + age);

        age = jedis.get("age");
        System.out.println("age=" + age);

        jedis.close();
    }
}
