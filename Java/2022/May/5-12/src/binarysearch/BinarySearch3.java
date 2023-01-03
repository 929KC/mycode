package binarysearch;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-12 17:08
 */

public class BinarySearch3 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int value = -1;
        int left = 0;
        int right = arr.length - 1;
        int ret = binarySearch(arr, left, right, value);
        System.out.println(ret);
    }

    private static int binarySearch(int[] arr, int left, int right, int value) {
        System.out.println("你好");
        //int mid = (left + right) / 2;
        int mid=left+(right-left)*(value-arr[left])/(arr[right]-arr[left]);
        if (left > right||value<arr[0]||value>arr[arr.length-1]) {
            return -1;
        }
        if (arr[mid] > value) {
            return binarySearch(arr, left, mid - 1, value);
        } else if (arr[mid] < value) {
            return binarySearch(arr, mid + 1, right, value);
        } else {
            return mid;
        }
    }
}
