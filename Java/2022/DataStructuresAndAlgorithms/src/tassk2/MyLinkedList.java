package tassk2;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-04-24 13:42
 */
class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data=data;
    }
}
public class MyLinkedList {
    public Node head; //无头单向链表的伪头节点

    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if(this.head==null){
            this.head = node;
            return;
        }
       node.next=this.head;
        this.head=node;
    }

    //尾插法
    public void addLast(int data){
        Node node=new Node(data);
        if(head==null){
            this.head=node;
        }
        Node cur=this.head;
        while(cur.next!=null){
            cur=cur.next;
        }
       cur.next=node;

    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index==0){
            addFirst(data);
            return ;
        }
       if(index==size()){
           addLast(data);
           return ;
       }
       Node node = new Node(data);
       //找到index位置的前一个节点的地址
       Node cur=searchIndex(index);
       //进行插入
       node.next=cur.next;
       cur.next=node;
    }

    private Node searchIndex(int index) {
        if(index<0||index>size()){
            throw new RuntimeException("index位置非法");
        }
        Node cur=this.head;
        while(index-1!=0){
            cur=cur.next;
            index--;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
      Node cur=this.head;
      while (cur!=null){
          if(cur.data==key){
              return true;
          }
          cur=cur.next;
      }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head==null){
            return ;
        }
        if(this.head.data!=key){
            this.head=this.head.next;
            return ;
        }
        Node prev=searchPrve(key);
        if(prev==null){
            System.out.println("没有要删除的节点");
            return;
        }
        Node del=prev.next;
        prev.next=del.next;

    }

    private Node searchPrve(int key) {
        Node prev=this.head;
        while(prev.next!=null){
            if(prev.data==key){
            return prev;
            }else{
                prev=prev.next;
            }
        }
        return null;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        if(this.head == null){
            return ;
        }
        Node prev=this.head;
        Node cur=this.head.next;
        while(cur!=null){
            if(cur.data==key){
            prev.next=cur.next;
            cur=cur.next;
            }else{
            prev=cur;
            cur=cur.next;
            }
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
    }

    //得到单链表的长度
    public int size(){
        Node cur=this.head;
        int size=0;
        while (cur != null){
            size++;
            cur=cur.next;
        }
        return  size;
    }

    public void display(){
        Node cur=this.head;
        while (cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
    }

    public void clear(){
        this.head=null;
    }

}
