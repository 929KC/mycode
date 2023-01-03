package task3;



import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-02 09:40
 */

public class Demo5 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.binarySearch(arr,6));
        System.out.println(MyBinarySearch(arr, 6));
    }

    private static int MyBinarySearch(int[] arr, int toFind) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (toFind < arr[mid]) {
            // 去左侧区间找
                right = mid - 1;
            } else if (toFind > arr[mid]) {
            // 去右侧区间找
                left = mid + 1;
            } else {
            // 相等, 说明找到了
                return mid;
            }
        }
            // 循环结束, 说明没找到
        return -1;
    }
}
