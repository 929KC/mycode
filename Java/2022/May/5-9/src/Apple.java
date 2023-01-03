/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-09 07:14
 */

public class Apple {
    public String name;
    public String color;
    public int age;

    public Apple(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public Apple() {
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}
