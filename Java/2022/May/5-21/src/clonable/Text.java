package clonable;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 20:21
 */

public class Text {
    public static void main(String[] args) {
        fun(new Person());
        fun(new Wallet());
    }

    private static void fun(Object o) {
        System.out.println(o);
    }
}
