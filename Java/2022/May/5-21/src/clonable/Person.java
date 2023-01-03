package clonable;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 17:49
 */

public class Person implements Cloneable {
    public int age;
    public  String name;
    public Wallet w = new Wallet();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person tmp = (Person) super.clone();
        tmp.w = (Wallet) this.w.clone();
        return tmp;
    }

//    @Override
//    public String toString() {
//        return "Person{" +
//                "age=" + age +
//                ", w=" + w +
//                '}';
//    }

//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }

    public static void main(String[] args) throws Exception {
        Person p = new Person();
        p.age = 90;
        System.out.println(p);
        System.out.println(p);
        Person p2 = (Person) p.clone();
        System.out.println(p2);
        System.out.println(p2.age);
        System.out.println("============");
        p2.age = 99;
        System.out.println(p2.age);
    }
}
