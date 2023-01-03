import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(4);
        set.add(6);
        set.add(1);
        for(Integer s:set) {
            System.out.println(s);
        }


    }
}
