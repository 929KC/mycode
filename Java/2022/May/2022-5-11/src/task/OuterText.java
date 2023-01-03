package task;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-11 20:57
 */

public class OuterText {

    public static void main(String[] args) {
        Outer o=new Outer();
        Outer.Inner in=o.new Inner();
        in.mathodC();
    }
}
