/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null  && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
              ListNode pa = head;
              ListNode pb = slow;

              while(pa!=pb){
                pa = pa.next;
                pb=pb.next;
              }
              return pa;
            }
        }
        
     
        return null;
    }
}