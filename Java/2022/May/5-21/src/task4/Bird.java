package task4;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 13:42
 */

public class Bird extends Animal implements IFly,IEat,IRunning{

    public Bird(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(name+"用翅膀飞");
    }

    @Override
    public void eat() {
        System.out.println(name+"吃虫");
    }

    @Override
    public void run() {
        System.out.println(name+"会用爪子跑");
    }
}
