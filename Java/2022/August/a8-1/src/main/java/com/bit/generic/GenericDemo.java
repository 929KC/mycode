package com.bit.generic;

public class GenericDemo {
    public static void main(String[] args) {
        String[] names = {"小黄", "小李", "小人"};
        printArray(names);
        Integer[] ages = {111, 222, 333};
        printArray(ages);
        Integer[] ages2 = getArr(ages);
        String[]  names2 = getArr(names);
    }

    public static <T> T[] getArr(T[] arr){
        return arr;
    }

    public static <T> void printArray(T[] arr){
        if(arr != null){
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(i == arr.length - 1 ? "" : ", ");
            }
            sb.append("]");
            System.out.println(sb);
        }else {
            System.out.println(arr);
        }
    }
}
