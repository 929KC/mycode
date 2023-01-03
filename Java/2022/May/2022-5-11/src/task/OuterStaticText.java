package task;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-11 21:14
 */

public class OuterStaticText {
    public static void main(String[] args) {
        OuterStatic.InnerStatic in= new OuterStatic.InnerStatic();
        in.method();
    }
}
