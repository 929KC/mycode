package com.kc.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {
    private static final JedisPool jedisPool;
    static{
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大连接
        jedisPoolConfig.setMaxTotal(8);
        //最小连接
        jedisPoolConfig.setMinIdle(0);
        //设置等待时长
        jedisPoolConfig.setMaxWaitMillis(200);
        jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1",
                6379,1000,"123456");
    }
    //获取jedis对象
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
