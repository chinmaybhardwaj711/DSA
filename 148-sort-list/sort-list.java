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
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        int cnt =1;
         ListNode temp = head;
        while(temp.next!= null){
            cnt++;
            temp = temp.next;
        }
        int nums[] = new int[cnt];
       
        temp = head;
       for(int i=0;i<cnt;i++){
            nums[i] = temp.val;
            temp = temp.next;
       }
       

       Arrays.sort(nums);
       ListNode newHead = new ListNode(-1);
       temp = newHead;
        for(int i=0;i<cnt;i++){
            ListNode node = new ListNode(nums[i]);
            temp.next = node;
            temp = temp.next;
        }
        return newHead.next;
    }
}