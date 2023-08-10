package org.example;

class Solution {

    public static String countAndSay(int n) {
        String ret = "1";
        for (int i = 1; i < n; i++) // 解释 n - 1 次 ret 即可
        {
          StringBuilder tmp = new StringBuilder();
            int len = ret.length();
            for (int left = 0, right = 0; right < len; ) {
                while (right < len && ret.charAt(left) == ret.charAt(right)) {
                    right++;
                }
                tmp.append(Integer.toString(right - left));
                tmp.append(ret.charAt(left));
                left = right;
            }
            ret = tmp.toString();
        }
        return ret;
    }

    public static void main(String[] args) {
        countAndSay(4);
    }
}