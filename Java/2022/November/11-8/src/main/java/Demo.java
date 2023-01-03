import java.util.ArrayList;

/**
 * @author 929KC
 * @date 2022/11/8 15:01
 * @description:
 */
public class Demo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }
}
