class Solution {
    public boolean isPalindrome(ListNode head) {
 ListNode fast=head;
           ListNode slow=head;
         
        if(head==null){
            return true;
        }
         
         
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
         
        ListNode cur=slow.next;
        while(cur!=null){
            ListNode curNext=cur.next;
            cur.next=slow;
            slow=cur;
            cur=curNext;
        }
         
        while(head!=slow){
            if(head.val!=slow.val){
                return false;
            }
            if(head.next==slow){
                return true;
            }
            head=head.next;
            slow=slow.next;
        }
        return true;
    
    }
}