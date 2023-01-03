package com.kc.thread;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * @author 929KC
 * @date 2022/12/15 20:54
 * @description:
 */
public class StreamDemo {
    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,6,7,8,9).reduce((integer, integer2) -> {
            String.format("%s: %d + %d = %d",
                    Thread.currentThread().getName(), integer, integer2, integer + integer2);
            return integer+integer2;
        }).ifPresent(System.out::println);
    }
}
