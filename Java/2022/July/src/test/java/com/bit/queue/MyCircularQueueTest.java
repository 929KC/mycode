package com.bit.queue;

import org.junit.Test;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-10 13:37
 */

public class MyCircularQueueTest {
    @Test
    public void testMyCircularQueue(){
        MyCircularQueue mc = new MyCircularQueue(1);
        System.out.println(mc.enQueue(1));
        System.out.println(mc.enQueue(2));

    }
}
