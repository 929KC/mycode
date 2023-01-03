package com.bit.queue;

import org.junit.Test;

import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-10 11:14
 */

public class ArrayQueueTest {
    @Test
    public void testArrayQueue() {
        ArrayQueue aq=new ArrayQueue();
        aq.offer(1);
        aq.offer(2);
        aq.offer(3);
        aq.offer(4);
        aq.traverse();
        System.out.println();
        System.out.println( aq.size());
        System.out.println(aq.peek());
        System.out.print(aq.poll());
        System.out.print(aq.poll());
        System.out.print(aq.poll());
        System.out.print(aq.poll());
        aq.traverse();
        System.out.println();
        System.out.println(aq.isEmpty());
        System.out.println(aq.isFull());
    }
}
