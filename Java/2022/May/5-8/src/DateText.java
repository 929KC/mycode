/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-08 19:55
 */

public class DateText {
    public static void main(String[] args) {
        // 构造三个日期类型的对象 d1 d2 d3
        Date d1 = new Date();
        Date d2 = new Date();
        Date d3 = new Date();
        // 对d1，d2，d3的日期设置
        d1.setDay(2020,9,15);
        d2.setDay(2020,9,16);
        d3.setDay(2020,9,17);
        // 打印日期中的内容
        d1.printDate();
        d2.printDate();
        d3.printDate();
    }
}
