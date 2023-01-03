package task;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-11 19:10
 */

public class Text {
    static int cnt = 6;
    static{
        cnt += 9;
    }

    public static void main(String[] args) {
        System.out.println(cnt);
    }
    static{
        cnt /=3;
    };
}
