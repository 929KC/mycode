package org.example.Functional;

public class Demo9 {
    public static String subAuthorName(String str, UseString useString){
        int start = 0;
        int length = 1;
        return useString.use(str,start,length);
    }
    public static void main(String[] args) {

        subAuthorName("黄茂荣", String::substring);

    }

     interface UseString{
            String use(String str,int start,int length);
        }
}
