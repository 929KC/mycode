package task3;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 11:29
 */

public class Text {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.powerOn();
        // 使用鼠标设备
        computer.useDevice(new Mouse());
        // 使用键盘设备
        computer.useDevice(new KeyBoard());
        computer.powerOff();
    }
}
