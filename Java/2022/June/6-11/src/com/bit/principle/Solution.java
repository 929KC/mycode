package com.bit.principle;

import java.util.HashMap;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-11 21:52
 */

public class Solution {
    public static void main(String[] args) {
        String s="aaabccccdd";
        int ret=longestPalindrome(s);
        System.out.println(ret);
    }
    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new    HashMap<>();
        int count = 0, flag = 0;
        for(char i : s.toCharArray()) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }

        for(Integer i : map.values()) {
            if(i%2 == 0) {
                count += i;
            }else{
                flag = 1;
                count += i-1;
            }
        }
        return count + flag;
    }


}
