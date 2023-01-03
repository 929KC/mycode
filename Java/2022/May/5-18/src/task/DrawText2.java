package task;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-18 20:14
 */

public class DrawText2 {
    public static void main(String[] args) {
        DrawShape();
    }
    public static void DrawShape(){
   Shape [] s={new Cycle(),new Flower(),new Rect(),new Cycle()};
        for (Shape shape : s) {
            shape.draw();
        }
    }
}
