package task;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-16 13:32
 */

public class Student extends Person {
    public int a = 90;
    public int b = 89;

    public void methodA(int a) {
        System.out.println("Student的方法A");
    }

    public void methodB() {
        System.out.println("Student的方法B");
    }
    public static void methodD(){
        this.methodA(12);
        this.methodB();
        super.methodA();
        super.methodB();
        System.out.println(this.a);
        System.out.println(this.b);
        System.out.println(super.a);
        System.out.println(super.b);
        System.out.println(super.c);
    }
    public void methodC(Student this) {
        this.methodA(12);
        this.methodB();
        super.methodA();
        super.methodB();
        System.out.println(this.a);
        System.out.println(this.b);
        System.out.println(super.a);
        System.out.println(super.b);
        System.out.println(super.c);

    }


    public static void main(String[] args) {
        Student s = new Student();
        s.methodC();
    }
}
