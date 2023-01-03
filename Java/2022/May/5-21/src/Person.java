import java.util.Objects;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 20:52
 */

public class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
