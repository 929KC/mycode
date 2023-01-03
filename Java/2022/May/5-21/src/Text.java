/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 20:54
 */

public class Text {
    public static void main(String[] args) {
        Person p=new Person("阿茂",19);
        Person p2=new Person("阿茂",19);
        System.out.println(p.hashCode());
        System.out.println(p2.hashCode());
    }
}
