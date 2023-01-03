package com.bit.arraylist;


/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-10 22:03
 */

public class Test {
    public static void main(String[] args) {
        MyList ml=new MyList();
        ml.add(0,1);
        ml.add(0,2);
        ml.add(0,3);
        System.out.println(ml.size());
        System.out.println(ml.contains(1));
        ml.display();
        System.out.println(ml.search(3));
        System.out.println(ml.getPos(1));
        ml.clear();
        System.out.println(ml.size());

    }
}
