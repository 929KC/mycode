package org.example.sort;

import java.util.Arrays;

public class SortUtil {

    /**
     * 冒泡排序
     * 时间复杂度:
     *
     * @param arr 待排序的数组
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{1,8,7,9,6,4,3,2,5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
