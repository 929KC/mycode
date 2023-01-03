

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-20 21:52
 */

public class Demo {
    public static void main(String[] args) {
        String s = "011101";
        System.out.println(Solution(s));

    }
    public static  int Solution(String s){
        int max=0;
        int left=0;
        int right=0;
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='1'){
               right++;
           }
        }
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='0'){
                left++;
            }else{
                right--;
            }
            max=Math.max(left+right,max);
        }
        return max;
    }

}
