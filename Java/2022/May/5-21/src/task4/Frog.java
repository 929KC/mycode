package task4;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 13:35
 */

public class Frog extends Animal implements IRunning,ISwimming,IEat {

    public Frog(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(name+"跳着走");
    }

    @Override
    public void swim() {
        System.out.println(name+"游泳");
    }

    @Override
    public void eat() {
        System.out.println(name+"吃浮游生物");
    }
}
