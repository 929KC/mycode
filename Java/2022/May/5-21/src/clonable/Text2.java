package clonable;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 20:37
 */

public class Text2 {
    public static void main2(String[] args) {
        Person p=new Person();
        p.age=90;
        Person p1=new Person();
        p1.age=90;
        System.out.println(p.age == p1.age);
        System.out.println(p == p1);
        System.out.println(p.equals(p1));
    }
    public static void main(String[] args) {
        Person p=new Person();
        p.name="叶秋涵";
        Person p1=new Person();
        p1.name="叶秋涵";
        System.out.println(p == p1);
        System.out.println(p.name.equals(p1.name));
    }
}
