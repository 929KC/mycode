package Demo;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-14 13:17
 */

public class Demo {
    private   int age;
    private   String name;
    private static  String school;

    public Demo() {
        System.out.println("无参构造器初始化");
    }

   static {
        System.out.println("静态代码块初始化");
        school = "家里蹲";
    }

    {
        System.out.println("实例代码块初始化");
        age = 12;
        name = "小白";
    }

    public void show() {
        System.out.println("name: " + name + " age: " + age + " schoo: " + school);
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        d.show();
    }
}
