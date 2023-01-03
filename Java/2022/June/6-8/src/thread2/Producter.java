package thread2;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-08 20:22
 */

public class Producter implements Runnable{
    private Product pro;

    public Producter(Product pro) {
        this.pro = pro;
    }
    @Override
    public void run() {
        int i = 0;
        while(true){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            if(i%2==0){
                this.pro.set("鼠标", 10);
            }
            else {
                this.pro.set("键盘", 5);
            }
            i++;
        }
    }
}
