package com.kc.redis;

import com.kc.utils.JedisConnectionFactory;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JdiesTest {
    private Jedis jedis;

    @Test
   public void TestJdeis(){
        //1.连接redis
        Jedis jedis = JedisConnectionFactory.getJedis();
        jedis.auth("123456");
        //2.操作redis
        String setResult = jedis.set("sam", "123");
        System.out.println(setResult);
        String value = jedis.get("sam");
        System.out.println(value);
        //3.关闭redis
        jedis.close();
    }

}
