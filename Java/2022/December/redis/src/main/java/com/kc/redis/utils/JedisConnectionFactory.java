package com.kc.redis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author 929KC
 * @date 2022/12/22 10:46
 * @description:
 */
public class JedisConnectionFactory {
    private static JedisPool jedisPool;
    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //配置连接池
        poolConfig.setMaxTotal(8);
        poolConfig.setMaxIdle(8);
        poolConfig.setMinIdle(0);
        poolConfig.setMaxWaitMillis(1000);
        //创建连接池
        jedisPool = new JedisPool(poolConfig,"120.78.166.85",6379,1000, "2222");
    }
    public  static Jedis getJedis(){
       return  jedisPool.getResource();
    }
}
