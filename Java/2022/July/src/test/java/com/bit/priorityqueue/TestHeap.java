package com.bit.priorityqueue;

import org.junit.Test;
import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-15 14:42
 */

public class TestHeap {
    @Test
    public void testHeap(){
        BigHeap bh=new BigHeap();
        int [] array={27,15,19,18,28,34,65,49,25,37};
        bh.init(array);
        bh.createHeap();
//        bh.heapSort();
//        System.out.println("排序后:"+Arrays.toString(bh.elem));
//        bh.offer(99);
//        System.out.println("大根堆:"+Arrays.toString(bh.elem));
//        System.out.println("堆顶元素:"+bh.peekHeap());
//        bh.poll();
//        System.out.println("出队后的大根堆:"+Arrays.toString(bh.elem));
        bh.heapSort();
        System.out.println("排序后:"+Arrays.toString(bh.elem));
        bh.offer(100);
        bh.heapSort();
        System.out.println("排序后:"+Arrays.toString(bh.elem));
    }
}
