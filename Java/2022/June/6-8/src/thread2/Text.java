package thread2;

import java.util.HashMap;
import java.util.Map;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-08 20:24
 */

public class Text {
    public static void main(String[] args) {
        Product p = new Product();
        Producter per = new Producter(p);
        Customer cer = new Customer(p);
        Thread tper = new Thread(per);
        Thread tcer = new Thread(cer);
        tper.start();
        tcer.start();

    }
}
