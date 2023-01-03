/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-08 20:43
 */

public class Apple {
    public String name="苹果";
    public String color="青色";
    public String type="青苹果";

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Apple a=new Apple();
        System.out.println(a);
    }
}
