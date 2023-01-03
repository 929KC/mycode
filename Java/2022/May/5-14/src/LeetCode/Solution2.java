package LeetCode;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-14 09:09
 */

public class Solution2 {
    public static void main(String[] args) {
        String []arr={"ci","car"};
       String s=longestCommonPrefix(arr);
        System.out.println(s);
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0||strs==null){
            return  "";
        }
        String left=strs[0];
        for(int i=1;i<strs.length;i++){
            left=longestCommonPrefix(left,strs[i]);
            if(left.length()==0){
                break;
            }
        }
        return left;

    }

    public static String longestCommonPrefix(String str1,String str2) {
        int length=Math.min(str1.length(),str2.length());
        int index=0;
        char [] ch1=str1.toCharArray();
        char [] ch2=str2.toCharArray();
        for(int i=0;i<length;i++){
            if(ch1[i]==ch2[i]){
                index++;
            }
        }
        return str1.substring(0,index);
    }
}
