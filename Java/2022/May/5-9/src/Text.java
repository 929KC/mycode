import static java.lang.Math.*;





/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-09 10:46
 */

public class Text {
    public static void main(String[] args) {
        double x = 30;
        double y = 40;
        // 静态导入的方式写起来更方便一些.
        // double result = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        double result = sqrt(pow(x, 2) + pow(y, 2));
        System.out.println(result);
    }
}
