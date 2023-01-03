package com.kc.redis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;


/**
 * @author 929KC
 * @date 2022/12/21 16:27
 * @description:
 */
 public class JedisTest {
    private Jedis jedis ;

    @BeforeEach
    void setUp() {
        jedis = new Jedis("120.78.166.85",6379);
        jedis.auth("2222");
    }
    @AfterEach
    public void close(){
        if(jedis!=null) {
            jedis.close();
        }
    }
    @Test
    public void testString (){
        String result = jedis.set("name","叶秋涵");
        String name = jedis.get("name");
        System.out.println("name:"+name);
    }
}
