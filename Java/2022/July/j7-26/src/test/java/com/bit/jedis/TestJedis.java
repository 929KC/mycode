package com.bit.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class TestJedis {

    @Test
    public void   testJedis(){
        //创建Jedis对象               
       Jedis jedis = new Jedis("127.0.0.1",6379);
        String  value = jedis.ping();
        System.out.println(value);
    }


}
