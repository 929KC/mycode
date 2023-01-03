package com.bit.linklist.one;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-10 21:46
 */

public class Test {
    public static void main(String[] args) {
        MyLinkedList ml=new MyLinkedList();
        ml.addFirst(12);
        ml.addFirst(13);
        ml.addIndex(2,14);
        ml.addIndex(3,14);
        ml.addLast(15);
        ml.display();
        System.out.println();
        System.out.println("========");
        System.out.println(ml.size());
        ml.remove(12);
        ml.removeAllKey(14);
        ml.display();
        System.out.println();
        System.out.println("========");
        System.out.println(ml.contains(13));
        ml.clear();
        System.out.println(ml.size());
    }
}
