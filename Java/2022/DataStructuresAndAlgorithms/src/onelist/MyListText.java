package onelist;

public class MyListText {
    public static void main(String[] args) {
        MyList myList=new MyList();
        for(int i=0;i<10;i++){
            myList.add(i,i);
        }
        myList.display();
        System.out.println(myList.size());
        myList.remove(4);
        myList.remove(0);
        myList.remove(9);
        myList.display();
        System.out.println(myList.search(6));
        System.out.println(myList.contains(6));
        myList.setPos(0,2);
        myList.display();
    }
}
