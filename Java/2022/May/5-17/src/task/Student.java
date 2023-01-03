package task;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @Description
 * @createDate: 2022-05-17 06:30
 */

public class Student extends Person {

    public Student(String name, int age) {
        super(name, age);
        System.out.println("子类构造方法执行");
    }

    {
        System.out.println("子类实例代码块执行");
    }

    static {
        System.out.println("子类静态代码块执行");
    }

    public static void main(String[] args) {
        new Student("老衲爱尼姑", 19);
        System.out.println("=============");
        new Student("老衲不爱尼姑",20);
    }
}
