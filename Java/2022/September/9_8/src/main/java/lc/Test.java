package lc;

public class Test {
    public static void main(String[] args) {
       String s = "  hello world!  ";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }

    public static String reverseWords(String s) {
        String [] arr = s.split(" ");
        StringBuffer sb =new StringBuffer();
        for (int i=arr.length-1;i>=0;i--) {
            sb.append(arr[i]+" ");
        }
        String str = sb.toString();

        return str.substring(0,str.length()-3);
    }
}
