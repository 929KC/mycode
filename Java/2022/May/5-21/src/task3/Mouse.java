package task3;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 11:16
 */

public class Mouse implements IUSB{
    @Override
    public void openDevice() {
        System.out.println("使用鼠标");
    }

    @Override
    public void closeDevice() {
        System.out.println("不使用鼠标");
    }

    public void click(){
        System.out.println("鼠标点击");
    }

}
