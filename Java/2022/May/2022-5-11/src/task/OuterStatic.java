package task;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-11 21:10
 */

public class OuterStatic {
    private int a;
    static int b;

    public void methodA(){
        a=90;
        System.out.println(a);
    }
    public static void methodB(){
        b=100;
        System.out.println(b);
    }

    public static class InnerStatic{

        public void method(){
           // a=90;
            b=78;
            methodB();
           // methodA();
        }


    }

}
