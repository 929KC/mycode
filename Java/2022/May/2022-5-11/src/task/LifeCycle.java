package task;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-11 19:53
 */

public class LifeCycle {
    //静态属性
    private static String staticField = getStaticField();

    //静态代码块
    static {
        System.out.println(staticField);
        System.out.println("静态代码初始化");
    }

    //普通属性/成员属性
    private String field = getField();

    //普通方法块/实例代码块
    {
        System.out.println(field);
        System.out.println("实例代码块初始化");
    }

    //构造函数初始化
    public LifeCycle() {
        System.out.println("构造函数初始化");
    }

    public static String getStaticField() {
        String statiFiled = "静态属性初始化";
        return statiFiled;
    }

    public static String getField() {
        String filed = "普通属性初始化";
        return filed;
    }

    public static void main(String[] argc) {
        new LifeCycle();
    }
}
