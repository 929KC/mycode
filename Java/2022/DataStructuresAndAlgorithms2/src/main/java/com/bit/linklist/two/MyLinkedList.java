package com.bit.linklist.two;

class ListNode {
    public int data;
    public ListNode prev;//链表的前驱
    public ListNode next;//链表的后继

    public ListNode(int data) {
        this.data = data;
    }
}

public class MyLinkedList {
    public ListNode head; //标识的头节点
    public ListNode tail; //标识的尾节点

    //头插法
    public void addFirst(int data) {
        ListNode ListNode = new ListNode(data);
        if (this.head == null) {
            this.head = ListNode;
            this.tail = ListNode;
        } else {
            ListNode.next = this.head;
            this.head.prev = ListNode;
            this.head = ListNode;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode ListNode = new ListNode(data);
        if (this.head == null) {
            this.tail = ListNode;
            this.head = ListNode;
        } else {
            this.tail.next = ListNode;
            ListNode.prev = this.tail;
            this.tail = ListNode;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size()) {
            throw new RuntimeException("index不合法");
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        checkIndex(index);
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        ListNode cur = searchListNode(index);
        ListNode ListNode=new ListNode(data);
        ListNode.next=cur;
        ListNode.prev=cur.prev;
        cur.prev.next=ListNode;
        cur.prev=ListNode;
    }

    private ListNode searchListNode(int index) {
        ListNode cur = this.head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public int  remove(int key) {
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                int oldData = cur.data;
                if(cur==this.head) {
                    this.head=this.head.next;
                  if(this.head!=null){
                      this.head.prev=null;
                  }
                }else{
                    cur.prev.next=cur.next;
                    if(cur.next!=null){
                      cur.next.prev=cur.prev;
                    }else{
                        //删除的是尾节点，只需要移动tail
                        this.tail=cur.prev;
                    }
                }
            return oldData;
            }
            cur=cur.next;
        }
        return -1;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                if(cur==this.head) {
                    this.head=this.head.next;
                    if(this.head!=null){
                        this.head.prev=null;
                    }
                }else{
                    cur.prev.next=cur.next;
                    if(cur.next!=null){
                        cur.next.prev=cur.prev;
                    }else{
                        //删除的是尾节点，只需要移动tail
                        this.tail=cur.prev;
                    }
                }
            }
            cur=cur.next;
        }
    }

    //得到单链表的长度
    public int size() {
        int size = 0;
        ListNode cur = this.head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    //打印链表
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
       while (this.head != null) {
           ListNode cur=this.head.next;
           this.head.prev=null;
           this.head.next=null;
           this.head=cur;
       }
       this.tail=null;
    }

}
