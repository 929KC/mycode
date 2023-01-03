public class ReveseString {
    public static void main(String[] args) {
        String str= reverseString("the sky is blue");
        System.out.println(str);
    }

    public static  String reverseString (String words) {
        StringBuilder sb = new StringBuilder(words);
        // write code here
        int start = 0;
        int end = 0;
        for (int i=0;i<sb.length();i++) {
            if (sb.charAt(i)==' '){
                end = i-1;
                swap(sb,start,end);
                start = i+1;
            }
        }
        end += 2;
        swap(sb,end,sb.length()-1);
        return  sb.toString();
    }

    private static void swap(StringBuilder str,int start,int end) {
        while (start<end) {
            char temp = str.charAt(start);
            str.setCharAt(start,str.charAt(end));
            str.setCharAt(end,temp);
            start++;
            end--;
        }
    }
}
