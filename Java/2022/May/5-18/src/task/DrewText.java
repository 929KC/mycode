package task;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-18 20:06
 */

public class DrewText {
    public static void main(String[] args) {
        DrawShape();
    }

    public static void DrawShape() {
        Rect r = new Rect();
        Cycle c = new Cycle();
        Flower f = new Flower();
        String[] s = {"cycle", "rect", "cycle", "rect", "flower"};
        for (String s1 : s) {
            if (s1.equals("rect")) {
                r.draw();
            } else if (s1.equals("cycle")) {
                c.draw();
            } else if (s1.equals("flower")) {
                f.draw();
            }
        }
    }
}
