package tassk2;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-04-24 16:41
 */

public class LinkedListText {
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.addFirst(12);
        myList.addFirst(13);
        myList.addFirst(14);
        myList.addFirst(15);
        myList.addFirst(16);
        myList.addIndex(2,23);
        myList.addIndex(2,23);
        myList.addIndex(2,23);
        myList.addIndex(2,23);

        myList.display();
        System.out.println();
        System.out.println(myList.contains(12));
        myList.remove(23);
        myList.display();
        System.out.println();
        myList.removeAllKey(23);
        myList.display();
        System.out.println();
        myList.clear();
        myList.display();

    }
}
