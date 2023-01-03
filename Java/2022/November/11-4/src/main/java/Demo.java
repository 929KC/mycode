import java.util.HashMap;

public class Demo {
    public static void main(String[] args) {
        int num = 2<<3;//2*8==16
        System.out.println(num);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("java",1);
        map.put("c++",2);
        System.out.println(map.size());
        String s = "hello-world";

    }
}
