package task4;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 13:38
 */

public class Text {
    public static void main(String[] args) {
        IRunning b = new Bird("小鸟");
        IRunning c = new Cat("小猫");
        IRunning f = new Frog("青蛙");
        IRunning d = new Duck("大黄鸭");
        b.run();
        c.run();
        f.run();
        d.run();
    }
}
