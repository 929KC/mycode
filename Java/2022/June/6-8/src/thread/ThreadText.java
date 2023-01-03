package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-08 09:55
 */

public class ThreadText {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<Product>();
        Thread pro=new Thread(new Producer(list));
        pro.setName("生产者");
        Thread cus=new Thread(new Customer(list));
        cus.setName("消费者");


    }
}
