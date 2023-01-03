package thread;

import java.util.List;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-08 09:52
 */

public class Producer implements Runnable {
    List<Product> list;

    public Producer(List<Product> list) {
        this.list = list;
    }

    @Override
    public void run() {

    }

}
