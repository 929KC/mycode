import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int m = sc.nextInt();
        int n = sc.nextInt();
        String table = "0123456789ABCDEF";
        StringBuffer sb = new StringBuffer("");
        boolean flag = false;
        if (m < 0) {
            m = -m;
            flag = true;
        }
        while (m != 0) {
            sb.append(table.charAt(  m % n));
            m = m/n;
        }
        if (flag) {
            sb.append("-");
        }
        sb.reverse();
        System.out.print(sb);
    }
}
