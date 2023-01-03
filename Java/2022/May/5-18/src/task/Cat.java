package task;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-18 07:38
 */

public class Cat extends Animal{
    @Override
    public Cat eat() {
     System.out.println(name+"吃老鼠");
     return new Cat(name,age);
    }

    Cat(String name, int age) {
       super(name, age);
    }
    public void bark(){
        System.out.println("喵喵");
    }

}
