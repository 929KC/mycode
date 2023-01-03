package task3;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-02 14:31
 */

public class Demo14 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        func(arr);
        System.out.println("arr[0] = " + arr[0]);

    }

    private static void func(int[] arr) {
        arr[0] = 10;
        System.out.println("a[0] = " + arr[0]);
    }
}
