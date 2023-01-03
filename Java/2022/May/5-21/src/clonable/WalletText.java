package clonable;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 19:03
 */

public class WalletText {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person();
        p.age=90;
        Person p1 = (Person) p.clone();
        System.out.println(p1.age);
        System.out.println(p1.w.money);
        System.out.println("修改后");
        p1.w.money=12;
        System.out.println(p1.w.money);
        System.out.println(p.w);
    }
}
