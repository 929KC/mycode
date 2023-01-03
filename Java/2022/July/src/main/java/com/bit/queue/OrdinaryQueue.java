package com.bit.queue;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-10 14:33
 */

import java.awt.print.Book;

/**
 * 普通队列
 *单向链表实现队列
 */
public class OrdinaryQueue {

    static class Node {
        private int val;
        private Node next;

        public Node(int val) {

        }
    }

    private Node head;
    private Node tail;

    public void offer(int val){
        Node node=new Node(val);
        if(head==null){
            head=node;
            tail=node;
        }else{
            tail.next=node;
            tail=tail.next;
        }

    }

    public int poll(){
        if(head==null){
            return -1;
        }
        int ret=head.val;
        if(head.next==null){
            head=tail=null;
        }else{
            head=head.next;
        }
        return ret;
    }

    public int peek(){
        if(head==null){
            return -1;
        }
        int ret=head.val;
        return ret;
    }

    /**
     * 队列中的有效个数
     * @return
     */
    public int size() {
       int size=0;
       Node cur=head;
       while(cur!=null){
           size++;
           cur=cur.next;
       }
       return size;
    }

    /**
     * 遍历队列
     */
    public void traverse(){
        Node cur=head;
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }
}
