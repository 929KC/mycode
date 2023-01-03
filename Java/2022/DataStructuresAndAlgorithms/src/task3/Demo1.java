package task3;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-02 07:29
 */

class TestArray {
    public static int[] fib(int n) {
        if (n <= 0) {
            return null;
        }
        int[] arr = new int[n];
        arr[0] = arr[1] = 1;
        for (int i = 2; i < n; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = fib(10);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}