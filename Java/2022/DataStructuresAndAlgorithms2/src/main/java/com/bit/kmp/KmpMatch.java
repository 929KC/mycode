package com.bit.kmp;

public class KmpMatch {
    public static void main(String[] args) {
        System.out.println(Kmp("ababcabcdabcde", "abcd", 0));
        String s = "ababcabcdabcde";
        System.out.println(s.length());
        System.out.println(Kmp("ababcabcdabcde", "abcde", 0));
        System.out.println(Kmp("ababcabcdabcde", "abcdef", 0));
    }

    /**
     * @param str 主串
     * @param sub 子串
     * @param pos 从子串的pos位置开始匹配
     * @return 找到子串在主串当中的下标
     */
    public static int Kmp(String str, String sub, int pos) {
        int i = pos;
        int j = 0;
        int lens = str.length();
        int lensub = sub.length();
        int[] next = new int[sub.length()];
        getNext(next, sub);
        while (i < lens && j < lensub) {
            if ((j == -1) || (str.charAt(i) == sub.charAt(j))) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j >= lensub) {
            return i - j;
        } else {
            return -1;
        }

    }

    private static void getNext(int[] next, String sub) {
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        //下一项
        int k = 0;//前一项的K
        while (i < sub.length()) {
            //next数组还没有遍历完
            if ((k == -1) || sub.charAt(k) == sub.charAt(i - 1)) {
                next[i] = k + 1;
                i++;
                k++;
            } else {
                k = next[k];
            }
        }
    }
}