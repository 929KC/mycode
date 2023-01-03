package com.bit.thread;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            StringBuffer str = new StringBuffer();
            String first = in.next();
            String second = in.next();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < second.length(); i++) {
                set.add(second.charAt(i));
            }

            for (int j = 0; j < first.length(); j++) {
                if (!set.contains(first.charAt(j))) {
                    str.append(first.charAt(j));
                }
            }
            System.out.print(str);
        }
    }
}
