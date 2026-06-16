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
    public ListNode findKth(ListNode temp, int k){
        k-=1;
        while( temp!= null && k>0){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        ListNode newHead = reverse(head.next);

        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
    
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode next;

        while(temp!=null){
            ListNode kthNode = findKth(temp,k);
            if(kthNode == null){
                if(prev != null){
                    prev.next = temp;
                    break;
                }
            }
            next = kthNode.next;
            kthNode.next = null;
            reverse(temp);
            if(temp == head){
                head = kthNode;
            }else{
                prev.next = kthNode;
            }
            prev = temp;
            temp = next;

        }
        return head;
    }
}