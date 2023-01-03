package task;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-18 15:01
 */

public class Demo {
    public static void main(String[] args) {
        System.out.println(add(12, 12));
        System.out.println(add(12, 12,12));
        System.out.println(add(12, 12,34.0));
    }
    public static  int add(int a,int b){
        return a+b;
    }
    public static  int add(int a,int b,int c){
        return a+b;
    }

    public static double add(int a,int b,double c){
        return a+b+c;
    }
}
