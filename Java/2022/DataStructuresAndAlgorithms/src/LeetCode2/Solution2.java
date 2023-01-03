package LeetCode2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-04 13:21
 */

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String world = sc.next();
        int ret = firstUniqChar(world,sc);
        System.out.println(ret);
    }

    public static int firstUniqChar(String s,Scanner sc) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
         char ch=s.charAt(i);
         map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }


}
