package com.bit.list;

import com.bit.linklist.two.MyLinkedList;
import org.junit.Test;


/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-10 16:44
 */

public class MyLinkedListTest {

    @Test
    public void testMyLinkedListTwo(){
        MyLinkedList myList = new MyLinkedList();
        myList.addFirst(12);
        myList.addFirst(11);
        myList.addFirst(9);
        myList.addFirst(8);
        myList.addFirst(7);
        myList.addIndex(4,10);
        myList.addIndex(5,10);
        myList.addLast(14);
        myList.display();
        System.out.println("==========");
        myList.remove(7);
        myList.removeAllKey(10);
        myList.clear();
        myList.display();
    }
}
