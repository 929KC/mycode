package com.bit.stack;

import org.junit.Test;



/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-09 21:25
 */

public class MyStackTest {
    @Test
    public void testStack() {
        MyStack ms=new MyStack();
        ms.push(11);
        ms.push(12);
        ms.push(13);
        ms.push(14);
        ms.push(15);
        ms.push(16);
        System.out.println(ms.size());
        System.out.println(ms.peek());
        System.out.println(ms.pop());
        ms.traverse();
    }
}
