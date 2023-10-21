package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入长度：");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("请输入 " + n + " 个数字：");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("请输入第k大的数：");
        int k = scanner.nextInt();

        int kthLargest = findKthLargest(arr, k);
        System.out.println("这 " + n + " 个数中第 " + k + " 大的数：" + kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
