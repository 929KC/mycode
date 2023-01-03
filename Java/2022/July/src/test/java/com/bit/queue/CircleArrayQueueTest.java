package com.bit.queue;

import org.junit.Test;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-10 13:11
 */

public class CircleArrayQueueTest {
    @Test
    public void testCircleArrayQueue(){
        CircleArrayQueue ca=new CircleArrayQueue(5);
        System.out.println(ca.enQueue(1));
        System.out.println(ca.enQueue(2));
        System.out.println(ca.enQueue(3));
        System.out.println(ca.enQueue(4));
        System.out.println(ca.enQueue(5));
        ca.traverse();
        System.out.println();
        System.out.println(ca.size());
    }
}
