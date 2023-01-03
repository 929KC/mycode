package task4;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 13:57
 */

public class Duck extends Animal implements IFly,IRunning,ISwimming,IEat{

    public Duck(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(name+"用鸭翅膀飞");
    }

    @Override
    public void run() {
        System.out.println(name+"用大脚趾跑");
    }

    @Override
    public void swim() {
        System.out.println(name+"游泳");
    }

    @Override
    public void eat() {
        System.out.println(name+"吃大米饭");
    }
}
