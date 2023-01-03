package com.kc.design.singleton;

import org.junit.Test;

/**
 * @author 929KC
 * @date 2022/11/6 22:43
 * @description:
 */
public class SingletonTest {

    @Test
    public void testSingletin(){
        Singleton s = new Singleton();
        Singleton instance1 = s.getInstance();
        Singleton instance2 = s.getInstance();
        if (instance1==instance2) {
            System.out.println("是同一个对象");
        }else {
            System.out.println("不是同一个对象");
        }
    }
}
