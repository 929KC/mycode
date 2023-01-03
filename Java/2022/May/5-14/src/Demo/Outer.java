package Demo;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-14 13:53
 */

public class Outer {
    int a = 90;
    public void study() {
        int b = 99;
        class Inner {
            public void print() {
                System.out.println(a);
                System.out.println(b);
            }
        }
        Inner in = new Inner();
        in.print();
    }

}
