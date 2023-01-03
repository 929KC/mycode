package task;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-04-24 12:37
 */

public class MyListText {
    public static void main(String[] args) {
        MyList myList=new MyList();
      for (int i=0; i<10;i++){
          myList.add(i,i);
      }
      myList.display();
        System.out.println();

         for (int i=10;i<=19;i++){
            myList.add(i,i);
         }
        myList.display();
        System.out.println();
        System.out.println(myList.size());
        System.out.println(myList.contains(19));
        System.out.println(myList.search(19));
        System.out.println(myList.getPos(12));
        myList.setPos(0,100);
        myList.remove(19);
        myList.contains(3);
        myList.search(3);
        myList.display();
    }
}
