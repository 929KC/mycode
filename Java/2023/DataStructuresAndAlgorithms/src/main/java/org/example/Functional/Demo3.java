package org.example.Functional;

import java.util.function.IntPredicate;

public class Demo3 {
    public static void printNum(IntPredicate predicate){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            if(predicate.test(i)){//判断是否是偶数
                System.out.println(i);//是的话直接打印
            }
        }
    }
    public static void main(String[] args) {
        //允许你定义并传递一个接受整数参数并返回布尔值的函数IntPredicate
        printNum(value -> value%2==0);
    }
}
