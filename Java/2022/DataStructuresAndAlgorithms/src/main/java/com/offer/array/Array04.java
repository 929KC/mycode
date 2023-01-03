package com.offer.array;

import javax.security.auth.login.CredentialException;
import java.util.ArrayList;
import java.util.List;

/**
 * 二维数组的二分查找
 */
class Array04 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30},
        };
        boolean flag = findNumberIn2DArray(matrix, 99);
        System.out.println(flag);
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        //判断该二维数组是否为空
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = 0;//行
          int j = matrix[0].length - 1;//列

        while (i < matrix.length && j >= 0) {
            if (target > matrix[i][j]) {
                i++;//排出行
            } else if (target < matrix[i][j]) {
                j--;//排除列
            } else {
                return true;//找到目标
            }
        }
        return false;//没有找到
    }

    /**
     * 和为S的连续正数序列
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        int left = 1;
        int right = 2;
        while (left < right) {
            int total = (left + right) * (right - left + 1) / 2;
            if (target == total) {
                int[] arr = new int[right - left + 1];
                for (int i = 0; i < right - left + 1; i++) {
                    arr[i] = i + left;
                }
                result.add(arr);
                right++;
            } else if (total < target) {
                right++;
            } else {
                left++;
            }
        }
        return result.toArray(new int [result.size()][]);
    }
    }