package com.bit.stack;

import com.bit.queue.MinStack;
import org.junit.Test;

/***
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-08 16:30
 */

public class MInStackTest {
    @Test
    public void test() {
        MinStack ms = new MinStack();
        ms.push(2);
        ms.push(0);
        ms.push(3);
        ms.push(0);
        ms.getMin();
        ms.pop();
        ms.getMin();
        ms.pop();
        ms.getMin();
        ms.pop();

    }
}
