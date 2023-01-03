package task;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-11 20:51
 */

public class Outer {
    private static int a;
    static int b;
    int c;

    public void methodA() {
        Outer.Inner in=new Outer().new Inner();
        in.name="黄老邪";
        System.out.println(in.name);
        a = 99;
        System.out.println(a);
    }

    public static void methoB() {
        Outer.Inner in=new Outer().new Inner();
        in.name="叶子秋";
        System.out.println(in.name);
        b = 100;
        System.out.println(b);
    }

    public class Inner {
        int c;
        static final int age=19;
        String name;
        public void mathodC() {
            a = 90;
            b = 100;
            methodA();
            methoB();
            c = 900;
            System.out.println(c);
            System.out.println(Outer.this.c);
        }
    }
}
