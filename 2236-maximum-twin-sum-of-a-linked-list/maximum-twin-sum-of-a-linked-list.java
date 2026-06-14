/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
          ListNode pre=null;
        ListNode curr=slow;
      
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=pre;
            pre =curr;
            curr=next;

        }
        int max=0;
        int sum=0;
        ListNode p1=head;
        ListNode p2=pre;
        while(p2!=null){
            sum=p1.val+p2.val;
            p1=p1.next;
            p2=p2.next;
            if(max<sum){
                max=sum;
            }
        }

     return max;

    }
}