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

    static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    private ListNode head;
    private ListNode tail;

    public void offer(int data){
        ListNode ListNode=new ListNode(data);
        if(head==null){
            head=ListNode;
            tail=ListNode;
        }else{
            tail.next=ListNode;
            tail=tail.next;
        }

    }

    public int poll(){
        if(head==null){
            return -1;
        }
        int ret=head.data;
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
        int ret=head.data;
        return ret;
    }

    /**
     * 队列中的有效个数
     * @return
     */
    public int size() {
       int size=0;
       ListNode cur=head;
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
        ListNode cur=head;
        while (cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
    }
}
