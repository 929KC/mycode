package clonable;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 19:39
 */

public class WalletText2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p=new Person();
        p.age=90;
        System.out.println(p);
        System.out.println("修改后");
        Person p1=(Person) p.clone();
        p1.age=90;
        p1.w.money=900;
        System.out.println(p1);
    }
}
