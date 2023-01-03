package task4;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 13:36
 */

public class Cat extends Animal implements IRunning,IEat{
    public Cat(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(name+"四条腿跑的快");
    }

    @Override
    public void eat() {
        System.out.println(name+"吃鱼");
    }
}
