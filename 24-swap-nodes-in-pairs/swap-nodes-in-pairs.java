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
 

   
    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode next;
        while(temp!=null){
            ListNode kthNode = temp.next;
            if(kthNode == null){
                if(prev != null){
                    prev.next = temp;
                   
                }
                 break;
               
            }
            next = kthNode.next;
            temp.next = next;
            kthNode.next = temp;
           
         
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