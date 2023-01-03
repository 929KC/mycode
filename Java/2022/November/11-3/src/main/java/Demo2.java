import java.util.*;

public class Demo2 {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("1","叶秋涵");
        map.put("2","林黛玉");
        map.put("3","妙玉");
        Set set = map.entrySet();
//        System.out.println(set.getClass());
//        for (Object o : set) {
//            System.out.print(o+" "+map.get(o));
//        }
        System.out.println("============");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key.getClass());
            System.out.println(key);
        }
        //System.out.println("=============");
//        Collection<String> values = map.values();
//        for (String value : values) {
//            System.out.print(value);
//        }
//        for (Object o : set) {
//            Map.Entry<String, String> entry = (Map.Entry<String, String>)o;
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }

    }
}
