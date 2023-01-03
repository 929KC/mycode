package com.kc.homework;

import java.util.Scanner;

public class isPalindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str1 = in.next();
        String str2 = in.next();
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            StringBuffer sb = new StringBuffer(str1);
            StringBuffer cur = sb.insert(i, str2);
            if (isPalindrome(cur)) {
                count++;
            }
        }
        System.out.print(count);
    }
    public static boolean isPalindrome(StringBuffer str) {
        int left = 0;
        int right = str.length()-1;
        while(left<=right) {
            if (str.charAt(left)==str.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }

}
