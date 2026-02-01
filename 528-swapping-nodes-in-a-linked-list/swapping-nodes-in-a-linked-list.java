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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        int i=1;
        while(i<k){
            fast = fast.next;
            i++;
        }
        ListNode first = fast;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

      ListNode  second = slow;  
        //swap
        int temp = second.val;
        second.val = first.val;
        first.val= temp;

        return head;
    }
}