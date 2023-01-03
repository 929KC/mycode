package com.offer.list;

import com.bit.linklist.one.ListNode;
import com.bit.linklist.one.MyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ListOperation {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(1);
        myLinkedList.addIndex(1,3);
        myLinkedList.addLast(2);
        myLinkedList.display();
        ListNode head= myLinkedList.searchIndex(0);
        int[] res = reversePrint(head);
        System.out.println();
        System.out.println(Arrays.toString(res));
    }
    public static int[] reversePrint(ListNode head) {
        //利用栈的先进后出,后进先出的特点
        Stack<Integer> stack = new Stack<>();;
        while (head!=null) {
            stack.push(head.data);
            head = head.next;
        }
        List<Integer> list = new ArrayList<>();;
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        int [] ret = new int [list.size()];
        int index = 0;
        for (Integer data:list) {
            ret[index++] = data;
        }
        return ret ;
    }

    /**
     * 使用递归从尾倒头打印
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new  ArrayList<>();
        printListFromTailToHeadHelp(listNode, list);
        return list;
    }

    public static void printListFromTailToHeadHelp(ListNode listNode, ArrayList list) {
        if (listNode == null) {
            return ;
        }
        printListFromTailToHeadHelp(listNode.next, list);
        list.add(listNode.data);
    }

    /**
     * 找到倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }
        ListNode first = head;
        ListNode slow = head;
        while (k > 0 && first != null) {
            first = first.next;
            k--;
        }
        while (first != null && slow != null) {
            slow = slow.next;
            first = first.next;
        }
        return k > 0 ? null : slow;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null) {
            return head;
        }
        ListNode first = head;
        ListNode second = first.next;
        ListNode third = second.next;
        while (third!=null) {
            second.next = first;
            first = second;
            second = third;
            third = third.next;
        }
        second.next = first;
        head.next = null;
        head = second;
        return head;
    }
}
