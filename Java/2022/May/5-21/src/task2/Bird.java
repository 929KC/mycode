package task2;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 10:33
 */

public class Bird extends Animal{
    @Override
    void eat() {
        System.out.println("鸟吃虫子");
    }

    @Override
    void run() {
        System.out.println("鸟用小爪子跳着走");
    }

    @Override
    void Swimming() {

    }

    @Override
    void fly() {
        System.out.println("鸟用翅膀飞");
    }
}
