package task3;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-02 14:27
 */

public class Demo13 {
    public static void main(String[] args) {
        int num = 0;
        func(num);
        System.out.println("num = " + num);
    }

    private static void func(int x) {
        x = 10;
        System.out.println("x = " + x);
    }
}
