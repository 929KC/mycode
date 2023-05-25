package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String s = scanner.nextLine();
        //使用空格将输入的字符串分割,如:I am is cat,分割后将I am is cat 分别作为一个字符串存在一个字符串数组里面
        String[] s1 = s.split(" ");
        System.out.println();
        //for循环就是将数组中的内容依次打印出来
        for (int i=0;i<s1.length;i++ ){
            System.out.print(s1[i]+ " ");
        }
    }
}