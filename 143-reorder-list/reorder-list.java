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
    public ListNode reverse(ListNode head){
        if(head == null || head.next ==  null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;
      ListNode temp2 =  reverse(right);

    ListNode temp = head;
  
     
     while(temp2!=null){
        //save the next pointers
        ListNode next1 = temp.next;
        ListNode next2 = temp2.next;

        //connext them
        temp.next = temp2;
        temp2.next = next1;

        //move 
        temp = next1;
        temp2 = next2;

     }
    }
}