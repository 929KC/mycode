package com.bit.linklist.one;

public class MyLinkedList {
    public ListNode head;

    //头插法
    public void addFirst(int data) {
        ListNode ListNode = new ListNode(data);
        if (this.head == null) {
            this.head = ListNode;
            return;
        }
        ListNode.next = this.head;
        this.head = ListNode;
    }

    //尾插法
    public void addLast(int data) {
        ListNode ListNode = new ListNode(data);
        ListNode cur = this.head;
        if (this.head == null) {
            this.head = ListNode;
            return;
        }
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = ListNode;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        //头插法
        if (index == 0) {
            addFirst(data);
            return;
        }
        //尾插
        if (index == this.size()) {
            addLast(data);
            return;
        }
        ListNode ListNode = new ListNode(data);
        //找到index位置的前一个节点的地址
        ListNode cur = searchIndex(index);
        //进行插入
        ListNode.next = cur.next;
        cur.next = ListNode;
    }

    public ListNode searchIndex(int index) {
        if (index < 0 || index > this.size()) {
            throw new RuntimeException("不合法");
        }
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
            cur = cur.next;
        }
        return false;
    }

    private ListNode searchPrev(int key) {
        ListNode prev = this.head;
        while (prev.next != null) {
            if (prev.next.data == key) {
                return prev;
            } else {
                prev = prev.next;
            }
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        ListNode prev = searchPrev(key);
        if (prev == null) {
            System.out.println("没有这个节点");
            return;
        }

        ListNode del = prev.next;
        prev.next = del.next;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if (this.head == null) {
            return;
        }
        ListNode prev = this.head;
        ListNode cur = this.head.next;//代表要删除的节点
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }

    //得到单链表的长度
    public int size() {
        ListNode cur = this.head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    //打印单链表
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    /**
     * 释放内存
     */
    public void clear() {
        this.head = null;
    }

}
