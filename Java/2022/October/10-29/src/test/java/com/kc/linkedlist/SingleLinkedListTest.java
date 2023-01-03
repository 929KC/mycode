package com.kc.linkedlist;

import com.kc.stack.MyStack;
import org.junit.Test;


import java.util.*;

public class SingleLinkedListTest {

    @Test
    public  void SingleLinkedListTest(){
        LinkedList list = new LinkedList();
        list.listIterator();
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addLast(1);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(3);
        singleLinkedList.addFirst(4);
        singleLinkedList.addFirst(5);
        singleLinkedList.addFirst(6);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(2);
        singleLinkedList.addLast(2);
        singleLinkedList.addIndex(3,2);
        singleLinkedList.addIndex(6,7);
        singleLinkedList.addIndex(0,8);
        singleLinkedList.addIndex(1,20);
        singleLinkedList.addIndex(1,99);
        singleLinkedList.display();
        System.out.println(singleLinkedList.contains(99));
        System.out.println(singleLinkedList.contains(7));
        System.out.println(singleLinkedList.contains(8));
        singleLinkedList.remove(9090);
        singleLinkedList.remove(8);
        singleLinkedList.remove(7);
        singleLinkedList.removeAllKey(2);
        singleLinkedList.display();
        System.out.println(singleLinkedList.size());
    }
    @Test
    public void testMyLinkedList(){
        MyLinkedList myList = new MyLinkedList();
        myList.addFirst(1);
        myList.addFirst(2);
        myList.addFirst(3);
        myList.addLast(4);
        myList.addLast(5);
        myList.addLast(6);
        myList.addFirst(1);
        myList.addFirst(1);
        myList.addFirst(1);
        myList.addLast(1);
        myList.addLast(1);
        myList.addIndex(6,1);
        myList.addIndex(7,1);
        myList.display();
        myList.remove(1);
        myList.display();
        myList.removeAllKey(1);
        myList.display();
        myList.clear();
        System.out.println(myList.contains(1));
        System.out.println(myList.size());
        LinkedList<String> list = new LinkedList<>();
    }

    @Test
    public void testStack(){
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.search(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.size());
        System.out.println(myStack.isEmpty());
    }

    @Test
    public  void test(){
        int [] arr = new int[]{1,5,67,783,2,4,6,7,90,21};
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if (arr[i]>max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }

}
