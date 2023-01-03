package com.bit.queue;

import org.junit.Test;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-10 15:54
 */

public class OrdinaryQueueTest {
    @Test
    public void testOrdinaryQueue()  {
        OrdinaryQueue o=new OrdinaryQueue();
        o.offer(1);
        o.offer(2);
        o.offer(3);
        o.offer(4);
        System.out.println(o.size());
        o.traverse();
    }
}
