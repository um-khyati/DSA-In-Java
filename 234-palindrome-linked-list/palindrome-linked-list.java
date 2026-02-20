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
    static int[] mirror = new int[100000];
    public boolean isPalindrome(ListNode head) {
        int i = 0;
        ListNode pre = head;
        while(pre != null){
            mirror[i++] = pre.val;
            pre = pre.next;
        }
        
        int l = 0;
         while (i > 0) {
            if (mirror[l++] != mirror[--i])
                return false;
        }
        return true;
    }
}