package task4;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 14:48
 */

public class Frog2 implements IAmphibious {
    @Override
    public void run() {
        System.out.println("青蛙跳着走");
    }

    @Override
    public void swim() {
        System.out.println("青蛙游泳");
    }
}
