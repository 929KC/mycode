package onelist;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-04-23 13:29
 */

public class MyLinkedListText {
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.addFirst(12);
        myList.addFirst(13);
        myList.addFirst(14);
        myList.addFirst(15);
        myList.addFirst(16);
        myList.display();
        System.out.println(myList.contains(12));
        myList.addIndex(3,23);
        myList.display();


    }
}
