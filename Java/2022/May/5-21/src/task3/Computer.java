package task3;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 11:17
 */

public class Computer  {
    public void powerOn(){
        System.out.println("打开笔记本电脑");
    }
    public void powerOff(){
        System.out.println("关闭笔记本电脑");
    }


    public void useDevice(IUSB usb){
        usb.openDevice();
        if(usb instanceof Mouse){
            Mouse mouse = (Mouse)usb;
            mouse.click();
        }else if(usb instanceof KeyBoard){
            KeyBoard keyBoard = (KeyBoard)usb;
            keyBoard.inPut();
        }
        usb.closeDevice();
    }
}
