package task;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-18 07:38
 */

public class Dog extends Animal{

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public Animal eat() {
        System.out.println(name+"吃肉");
        return new Animal(name,age);
    }
    public void bark(){
        System.out.println("汪汪");
    }
}
