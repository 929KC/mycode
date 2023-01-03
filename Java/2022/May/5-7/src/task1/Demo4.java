package task1;

import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-07 09:51
 */

public class Demo4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 9;
        int index = myBinarySearch(arr, target);
        System.out.println(index);
    }

    private static int myBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > arr[mid]) {
                left=mid+1;
            } else if (target < arr[mid]) {
                right=mid-1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
