package org.example.Functional;

import java.util.function.IntBinaryOperator;

public class Demo2 {
    public static int calculateNum(IntBinaryOperator operator){
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }

    public static void main(String[] args) {
        int i = calculateNum((left, right) -> left + right);
        System.out.println(i);
    }
}
