package org.example.list;

public class SingleLinkedList {

    class ListNode {
        private ListNode next;
        private int data;

        public ListNode(int data) {
            this.data = data;
        }
    }

    /**
     * 标记头节点
     */
    private ListNode head;

    /**
     * 头插
     *
     * @param data
     */
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    /**
     * 尾插
     *
     * @param data
     */
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if (head == null) {
            this.head = node;
            return;
        }
        while (cur != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    /**
     * 任意位置插
     *
     * @param index
     * @param data
     */
    public void addIndex(int index, int data) {
        if (index < 0 || index > getSize()) {
            System.out.println("index非法");
        }
        if (index == 0) {
            addFirst(data);
        }
        if (index == getSize()) {
            addLast(data);
        }
        ListNode node = new ListNode(data);
        ListNode per = searchIndexNode(index);
        node.next = per.next;
        per.next = node;
    }

    public ListNode searchIndexNode(int index) {
        if (index < 0 || index > getSize()) {
            System.out.println("index非法");
        }
        ListNode cur = this.head;
        while (index != 0) {
            cur = cur.next;
        }
        return cur;
    }

    public boolean containsKey(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        ListNode prev = searchByKey(key);
        if (prev == null) {
            System.out.println("没有这个节点");
            return;
        }
        ListNode del = prev.next;
        prev.next = del.next;
    }

    public void removeAll(int key) {
        if ( this.head == null){
            return;
        }
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while (cur!=null){
            if (cur.data==key) {
                prev.next = cur.next;
            }else {
                prev =cur;
                cur = cur.next;
            }
        }
        if (this.head.data==key) {
            this.head = this.head.next;
        }
    }

    private ListNode searchByKey(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.next.data == key) {
                return cur;
            } else {
                cur = cur.next;
            }
        }
        return null;
    }

    public int getSize() {
        ListNode cur = this.head;
        int size = 0;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        return size;
    }
    public void clear() {
       this.head = null;
    }
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
    }


    public static void main(String[] args) {

    }
}
