package thread2;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-08 20:23
 */

public class Product {
    private String name = "鼠标";
    private int count = 10;
    private boolean flag = false;
    public synchronized void set(String name,int count){
        if(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        this.name = name;
        this.count = count;
        System.out.println("工厂制造了"+this.name+",一共"+this.count+"件");
        notify();
    }
    public synchronized void get(){
        if(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("顾客购买了"+this.name+",一共"+this.count+"件");
        notify();
    }
}
