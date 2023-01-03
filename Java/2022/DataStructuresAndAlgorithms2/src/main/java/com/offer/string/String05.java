package com.offer.string;


import java.util.ArrayList;
import java.util.Collections;

/**
 * 替换空格
 */
class String05 {
    public static void main(String[] args) {
          String s = "abc";
          ArrayList<String> permutation = Permutation(s);
        for (String s1 : permutation) {
            System.out.print(s1+" ");
        }

//        String s = "We are happy.";
//        String res = replaceSpace(s);
//        System.out.println(res);
    }
    public static String replaceSpace(String s) {
        StringBuffer str = new StringBuffer(s);
        //统计字符串中的空格
        int count = 0;
        for (int i = 0;i<str.length();i++) {
            char ch = str.charAt(i);
            if (ch==' ') {
                count++;
            }
        }
        //新字符串长度
        int newLen = str.length()+2*count;
        //原字符串的末尾
        int oldIndex = str.length()-1;
        //新字符串的末尾
        int newIndex = newLen-1;
        //设置新字符串长度
        str.setLength(newLen);
        while (oldIndex>=0&&newIndex>=0) {
            if (str.charAt(oldIndex)==' '){
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
                oldIndex--;
            }else{
                str.setCharAt(newIndex--,str.charAt(oldIndex));
                oldIndex--;
            }
        }
        return str.toString();
        //  char [] arr=new char [s.length()*3];
        // int size=0;
        // for(int i=0;i<s.length();i++){
        //     char index=s.charAt(i);
        //     if(index==' '){
        //         arr[size++]='%';
        //         arr[size++]='2'; 
        //         arr[size++]='0';
        //     }else{
        //         arr[size++]=index;
        //     }
        // }
        // return   new String(arr,0,size);
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str!=null&&str.length()>0) {
            PermutationHelper(str.toCharArray(), 0, result);
            Collections.sort(result);
        }
        return result;
    }

    private static void PermutationHelper(char[] str, int start, ArrayList<String> result) {
        if (start==str.length-1) {
            if(!isExit(result,str)){
                result.add(new String(str));
            }
            return;
        }
        for (int i=start;i<str.length;i++) {
            swap(str,start,i);
            PermutationHelper(str,start+1,result);
            swap(str,start,i);
        }
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    private static boolean isExit(ArrayList<String> result, char[] str) {
        return result.contains(String.valueOf(str));
    }
}