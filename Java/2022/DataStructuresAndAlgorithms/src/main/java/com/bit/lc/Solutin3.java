package com.bit.lc;//package com.bit.lc;
//
//import java.util.HashMap;
//
//public class Solutin3 {
//
//        public ListNode copyRandomList(ListNode head) {
//            Map<ListNode,ListNode> map = new HashMap<>();
//            ListNode  cur = head;
//            while (cur!=null) {
//                ListNode newListNode = new ListNode (cur.data);
//                map.put(cur,newListNode);
//                cur = cur.next;
//            }
//            cur = head;
//            while (cur!=null) {
//                map.get(cur).next = map.get(cur.next);
//                map.get(cur).random = map.get(cur.random);
//                cur= cur.next;
//            }
//            return map.get(head);
//        }
//
//
//}
