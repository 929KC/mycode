import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * @author 929KC
 * @date 2022/11/5 15:57
 * @description:
 */
public class Demo {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.forEach(( key,  value) -> System.out.println(key+" "+value));
        Collection<Integer> values = map.values();
        Set<String> keySet = map.keySet();

    }
}
