package inner;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-14 15:17
 */

public class Text {
    public static void main(String[] args) {
        Animal a = new Animal() {
            @Override
            public void run() {
                System.out.println("老虎跑的快！");
            }
        };
        a.run();
    }
}

abstract class Animal {
    public abstract void run();
}


