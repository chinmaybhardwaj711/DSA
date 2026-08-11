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
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode revl1 = reverse(l1);
        ListNode revl2 = reverse(l2);
        int carry=0;
        ListNode temp = new ListNode(-1);
        ListNode dummy = temp;
        while(revl1!=null || revl2!=null || carry ==1){
            int sum =0;
            if(revl1!=null){
                sum+=revl1.val;
                revl1 = revl1.next;

            }
            if(revl2!=null){
                sum+=revl2.val;
                revl2 = revl2.next;
            }
            sum+=carry;
             int digit = sum%10;
             carry = sum/10;
            ListNode node = new ListNode(digit);
             dummy.next = node;
             dummy =  dummy.next;
          

        }
        return reverse(temp.next);
    }
}