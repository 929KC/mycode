package task;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-18 07:41
 */

public class Text {

    public static void main(String[] args) {
        //1.直接赋值
        Animal c=new Cat("阿猫",2);
        Animal d=new Dog("阿狗",3);

       if(c instanceof Cat){
           Dog d1=(Dog)d;//向下转型
           d1.bark();
       }

      if((c instanceof Cat)){
          Cat c2=(Cat)c;
          c2.bark();
      }
        method(c);
        method(d);

    }
    // 2. 方法传参：形参为父类型引用，可以接收任意子类的对象
    public static void method(Animal a){
        a.eat();
    }
    // 3. 作返回值：返回任意子类对象
    public static Animal buyAnimal(String var){
        if("狗" == var){
            return new Dog("狗狗",1);
        }else if("猫" == var){
            return new Cat("猫猫", 1);
        }else{
            return null;
        }
    }
}
