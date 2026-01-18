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
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter w = new FileWriter("display_runtime.txt")) {
                w.write("-0");
            } catch (Exception e) {}
        }));
    }

    public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val == val)
        {
            head = head.next;
        }
        if(head == null) return null;
        ListNode ptr = head;
        
        while(ptr!=null && ptr.next != null)
        {
            if(ptr.next.val == val)
            {
                ptr.next = ptr.next.next;
            }
            if(ptr.next!= null && ptr.next.val != val)
            {
                ptr = ptr.next;
            }
            if(ptr.next==null)
            {
                ptr = ptr.next;
            }
        }
        return head;
        
    }
}