package LeetCode;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-14 07:51
 */

public class Solution {
    public static void main(String[] args) {
        String s="XXOX";
        System.out.println(minimumMoves(s));
    }
    public static int minimumMoves(String s) {
       char [] arr=s.toCharArray();
        int count=0;
        int left=0;
        while(left<arr.length){
            if(arr[left]=='O'){
                left++;
                continue;
            }
            int k=3;
            while (k>0&&left<arr.length){
                arr[left++]='O';
                k--;
            }
            count++;
        }
        return count;
    }
}
