/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-08 19:54
 */

public class Date {
    public int year;
    public int month;
    public int day;
    public void setDay(int year, int month, int day){
        this.year = year;
        this.month = month;
       this.day = day;
    }
    public void printDate(){
        System.out.println(year + "-" + month + "-" + day);
    }
}
