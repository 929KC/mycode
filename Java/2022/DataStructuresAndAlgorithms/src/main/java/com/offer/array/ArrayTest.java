package com.offer.array;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int [] ret = new int []{1,1,2,2,3,3,5,7,7,8};
        int [] num1= new int[1];
        int [] num2= new int[1];
        FindNumsAppearOnce(ret,num1,num2);
        System.out.println(Arrays.toString(ret));
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));

    }

    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array==null||num1==null||num2==null) {
            return;
        }
        num1[0] = 0;
        num2[0] = 0;
        int result = array[0];
        for (int i = 1;i<array.length;i++) {
            result^=array[i];
        }
        int size = Integer.SIZE;
        int flag = 1;
        while (size>0) {
            size--;
            if (((flag<<size)&result)!=0) {//找到2个数比特位不一致的位置
                flag<<= size;
                break;
            }
        }
        for (int i=0;i<array.length;i++) {
            if ((array[i]&flag)==0) {//异或，满足交换律
                num1[0] ^=array[i];
            }else{
                num2[0]^=array[i];
            }
        }
    }
}
