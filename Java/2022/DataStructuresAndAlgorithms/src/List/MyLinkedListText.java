package List;

import onelist.MyLinkedList;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-04-24 09:24
 */

public class MyLinkedListText {
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.addFirst(1);
        myList.addFirst(2);
        myList.addFirst(3);
        myList.addFirst(4);
        myList.display();
        System.out.println();
        myList.addIndex(0,99);
        myList.addIndex(3,29);
        myList.addIndex(4,99);
        myList.display();
        System.out.println();
       // myList.clear();
        System.out.println(myList.contains(99));
        myList.remove(99);
        myList.removeAllKey(99);
        System.out.println(myList.contains(99));
        System.out.println(myList.size());
        myList.display();
    }
}
