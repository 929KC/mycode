import java.util.Iterator;
import java.util.LinkedList;

public class Demo2 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("删除前:"+list);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            if (next==3){
                iterator.remove();
            }
        }
        System.out.println("删除后:"+list);
    }
}
