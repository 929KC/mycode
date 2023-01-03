package binarysearch;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-12 16:42
 */

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int value = 9;
        int ret = binarySearch(arr, value);
        System.out.println(ret);
    }

    private static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            System.out.println("你好");
            int mid = (left + right) / 2;
            if (arr[mid] > value) {
                right = mid - 1;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
