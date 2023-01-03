package com.kc.linkedlist;

public class SingleLinkedList {
  static class Node{
     public Node next;
     public int data;

      public Node(int data) {
          this.data = data;
      }
  }
  public  Node head;//表示存储当前链表头节点的引用

    /**
     *
     * @param data 插入的元素
     */
    public void addFirst(int data){
        Node node = new Node(data);
        if (this.head==null) {
            this.head = node;
            return ;
        }
        node.next = this.head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        Node cur = this.head;
        if (this.head==null) {
            this.head = node;
            return ;
        }
        while (cur.next!=null) {
            cur = cur.next;
        }
        cur.next = node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if (index<0||index>this.size()) {
            System.out.println("index位置不合法");
        }
        if (index==0) {
            addFirst(data);
            return;
        }
        if (index==this.size()) {
            addLast(data);
            return;
        }
        Node node = new Node(data);
        Node cur = searchIndex(index);//找到要插入节点的前一个节点
        //进行插入
        node.next = cur.next;
        cur.next = node;
    }

    /**
     *
     * @param index
     * @return
     */
    private Node searchIndex(int index) {
        if (index<0||index>this.size()) {
            throw new RuntimeException("index不合法");
        }
        Node cur = this.head;
        while (index-1!=0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    /**
     * 查找是否包含关键字key是否在单链表当中
     *
     * @param key
     * @return
     */
    public boolean contains(int key){
        Node cur = this.head;
        if (this.head==null) {
            return false;
        }
        while (cur!=null) {
            if (cur.data==key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除第一次出现关键字为key的节点
     * @param key
     */
    public void remove(int key){
        if (this.head==null) {
            return ;
        }
        if (this.head.data==key) {
            this.head = this.head.next;
        }
        Node prev = searchPrev(key);
        if (prev==null) {
            return ;
        }
        Node del = prev.next;
        prev.next = del.next;
    }

    /**
     * 寻找要删除节点的前驱
     * @param key
     * @return
     */
    private Node searchPrev(int key) {
        Node prev = this.head;
        while (prev.next!=null) {
             if (prev.next.data==key) {
                 return prev;
             }else {
                 prev = prev.next;
             }
        }
        return null;
    }

    /**
     * 删除所有值为key的节点
     * @param key
     */
    public void removeAllKey(int key){
        if (this.head==null) {
            return ;
        }
        Node prve = head;
        Node cur = head.next;
        while (cur!=null) {
            if (cur.data==key) {
                prve.next = cur.next;
                cur = cur.next;
            }else{
                prve = cur;
                cur = cur.next;
            }
        }

        if (this.head.data==key) {
            this.head = this.head.next;
        }
    }

    /**
     * 遍历链表
     */
    public void display() {
        Node cur = this.head;
        while (cur!=null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 获得链表的长度
     * @return
     */
    public int size(){
        Node cur = this.head;
        int size = 0;
        while (cur!=null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    public void clear(){
        this.head = null;
    }
}
