package com.bit.servlet;

import java.util.HashMap;
import java.util.Map;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-29 15:34
 */

public class Solution {
    public static void main(String[] args) {
        String s="dog cat cat dog";
        System.out.println(s.charAt(0));
//        String p = "abba";
//        String s = "dog cat cat fish";
//        boolean flag = wordPattern(p, s);
//        System.out.println(flag);
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        char[] arr2 = pattern.toCharArray();
        Map<Character, String> map1 = new HashMap<Character, String>();
        Map<String, Character> map2 = new HashMap<String, Character>();
        for (int i = 0; i < arr2.length; i++) {
            char x = arr2[i];
            String y = arr[i];
            if (map1.containsKey(x) && !map1.get(x).equals(y) || map2.containsKey(y) && !map2.get(y).equals(x)) {
                return false;
            }
            map1.put(x, y);
            map2.put(y, x);
        }
        return true;
    }
}
