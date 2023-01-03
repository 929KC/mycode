package thread2;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-08 20:24
 */

public class Customer implements Runnable{
    private Product pro;

    public Customer(Product pro) {
        this.pro = pro;
    }
    @Override
    public void run() {

        while(true){
            this.pro.get();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
