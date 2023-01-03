package com.kc.linkedlist;

public class MyLinkedList {
    public Node head;
    public Node last;

    static class Node {
        public Node next;
        public Node prev;
        public int data;
        public Node(int data) {
            this.data = data;
        }
    }

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
            return;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
            return;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = this.last.next;
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        if (index < 0 || index > this.size()) {
            throw new RuntimeException("index不合法");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == this.size()) {
            addLast(data);
        }
        Node node = new Node(data);
        Node cur = findIndex(index);
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }

    private Node findIndex(int index) {
        Node cur = this.head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                //处理头节点
                if (cur == this.head) {
                    this.head = this.head.next;
                    if (this.head != null) {
                        //防止只有一个节点
                        this.head.prev = null;
                    }
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        //处理中间节点
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }

                }
                return;
            }
            cur = cur.next;
        }

    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                //处理头节点
                if (cur == this.head) {
                    this.head = this.head.next;
                    if (this.head != null) {
                        //防止只有一个节点
                        this.head.prev = null;
                    }
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        //处理中间节点
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }

                }
            }
            cur = cur.next;
        }
    }

    /**
     * 得到单链表的长度
     *
     * @return
     */
    public int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    /**
     * 遍历链表
     */
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
        while (this.head!=null) {
            Node curNext = this.head.next;
            this.head.next = null;
            this.head.prev = null;
            this.head = curNext;
        }
        this.last = null;
    }

}
