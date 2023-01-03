package task2;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 10:34
 */

public class Fish extends Animal{
    @Override
    void eat() {
        System.out.println("鱼吃微生物");
    }

    @Override
    void run() {

    }

    @Override
    void Swimming() {
        System.out.println("鱼在水里游泳");
    }

    @Override
    void fly() {

    }
}
