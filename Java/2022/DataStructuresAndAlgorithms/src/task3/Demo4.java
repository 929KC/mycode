package task3;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-02 09:37
 */

public class Demo4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 10, 5, 6};
        System.out.println(find(arr, 10));
    }

    private static int find(int[] arr, int data) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                return i;
            }
        }
        return -1; // 表示没有找到
    }

}
