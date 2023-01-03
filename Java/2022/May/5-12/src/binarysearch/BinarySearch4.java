package binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-12 17:31
 */

public class BinarySearch4 {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int value = 9;
        int left = 0;
        int right = arr.length - 1;
        List<Integer> list = binarySearch(arr, left, right, value);
        System.out.println(list);
    }

    private static List<Integer> binarySearch(int[] arr, int left, int right, int value) {
        System.out.println("你好");
        //int mid = (left + right) / 2;
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);

        if (left > right||value<arr[0]||value>arr[arr.length-1]) {
            return new ArrayList<Integer>();
        }
        if (arr[mid] > value) {
            return binarySearch(arr, left, mid - 1, value);
        } else if (arr[mid] < value) {
            return binarySearch(arr, mid + 1, right, value);
        } else {
            List<Integer> list = new ArrayList<Integer>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != arr[mid]) {
                    break;
                }
                list.add(temp);
                temp -= 1;
            }
            list.add(mid);
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != arr[mid]) {
                    break;
                }
                list.add(temp);
                temp += 1;
            }
            return list;
        }

    }

}
