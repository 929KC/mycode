package com.kc.foundation.utils;

import java.util.Arrays;

/**
 * @author 929KC
 * @date 2023/1/6 20:36
 * @description:
 */
public class SortUtil {

    /**
     * @param array
     * @author 929KC
     * @date 2023/1/6 2023/1/6
     * @description：
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            //-i,每次冒泡一次就会确定一个最大值,从第二趟开始就确定了2个最值,就会产生一次多余的比较,-i就是对此进行优化
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                return;//判断数组是否在排序过程中是否已经有序
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 2, 5, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 直接插入排序
     * 时间复杂度:最好:o(n),平均o(n^2),最坏o(n^2)
     * 空间复杂度:o(1)
     * 稳定性:稳定 一个稳定的排序->不稳定
     */
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i-1;
            int temp = arr[i];
            for (; j >= 0; j--) {
                if (arr[j]>temp) {
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = temp;
        }
    }

    private static void selectSort(int[] arr) {

    }
}
