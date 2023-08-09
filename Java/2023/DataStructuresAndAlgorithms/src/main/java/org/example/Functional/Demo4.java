package org.example.Functional;

import java.util.function.Function;

public class Demo4 {
    public static <R> R typeConver(Function<String,R> function){
        String str = "1235";
        R result = function.apply(str);
        return result;
    }
    public static void main(String[] args) {
        Integer result = typeConver(s -> Integer.valueOf(s));
        System.out.println(result);
    }
}
