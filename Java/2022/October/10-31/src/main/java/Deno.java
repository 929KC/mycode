import java.util.*;

// list.clear();
//         list.addFirst(12);
//         list.add(1);
//         list.add(2);
//         list.add(3);
//         list.add(1,9);
//         list.get(2);
//         list.indexOf(2);
//         Integer integer = list.removeFirst();
//         System.out.println(integer);
//         System.out.println(list);
//         ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        arrayList.add(4);
//        arrayList.add(5);
//        arrayList.add(6);
//        list.addAll(1,arrayList);
public class Deno {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.add(4);
        System.out.println(list);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
//        System.out.println();
//        for (int i=0;i<list.size();i++) {
//            System.out.print(list.get(i)+" ");
//        }
//        System.out.println();
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.print(iterator.next()+" ");
//            iterator.remove();
//        }
//        System.out.println();
        ListIterator<Integer> iterator2 = list.listIterator();
//        while (iterator2.hasNext()) {
//            System.out.print(iterator2.next()+" "+iterator2.previousIndex()+" "+ iterator2.nextIndex());
//
//        }
        while (iterator2.hasPrevious()) {
           Integer value = iterator2.previous();
            System.out.print(value+" ");
        }
    }
}
