package com.kc.dmeo;

import com.kc.demo.MyArrayList;
import org.junit.Test;

public class MyArrayListDemo {
    @Test
    public void testMyArrayList(){
        MyArrayList myList = new MyArrayList();
        myList.add(1);
        myList.add(2);
        myList.add(1,3);
        myList.get(0);
        myList.set(0,99);
        myList.display();
        myList.contains(2);
        System.out.println(myList.indexOf(2));
        System.out.println(myList.lastIndexOf(2));
        myList.display();
        myList.remove(99);
        System.out.println(myList.size());
        myList.get(4);

    }
}
