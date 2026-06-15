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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        ListNode slow = head;
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode delNode = slow.next;
        slow.next = slow.next.next;
        return head;
        // int sz =0;
        // ListNode temp = head;
        // while(temp!=null){
        //     temp = temp.next;
        //     sz++;
        // }
        // if(sz == n){
        //     head = head.next;
        //     return head;
        // }

        // int idxtoFind = sz-n;
        // int i=1;
        // ListNode prev = head;
        // while(i<idxtoFind){
        //     prev = prev.next;
        //     i++;
        // }
        // prev.next = prev.next.next;
        // return head;

    }
}