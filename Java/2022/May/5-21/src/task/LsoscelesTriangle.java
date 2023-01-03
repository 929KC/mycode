package task;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 09:37
 */

public class LsoscelesTriangle extends Triangle {

    @Override
    public void draw() {
        System.out.println("画一个等腰三角形");
    }

    @Override
    public void print() {
        System.out.println("我是一个等腰三角形");
    }

    @Override
    public void rotating() {
        System.out.println("等腰三角形旋转90度");
    }
}
