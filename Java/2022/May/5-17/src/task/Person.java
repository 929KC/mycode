package task;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-17 06:30
 */

public class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("父类构造方法执行");
    }
    {
        System.out.println("父类实例代码块执行");
    }
    static{
        System.out.println("父类静态代码块执行");
    }

}
