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

    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                tail.next = l2;
                l2 =l2.next;
            }else{
                tail.next = l1;
                l1 = l1.next;
            }
            tail = tail.next;
        }
        tail.next = (l1!=null)?l1:l2;
        return dummy.next;
    }

    public static  ListNode mergeRange(ListNode lists[], int left, int right){
        if(left== right){
            return lists[left];
        }
        int mid = left + (right-left)/2;

        ListNode l1 = mergeRange(lists,left,mid);
        ListNode l2 = mergeRange(lists,mid+1,right);

        return merge(l1,l2);
    } 
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        return mergeRange(lists, 0, lists.length-1);

    
    }
}