/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int cnt =0;
    public int count(TreeNode node){
   
        if(node == null){
            return Integer.MIN_VALUE ;
        }
        
        // if(node.left == null && node.right == null){
        //     cnt++;
        //     return;
        // }
      int leftMax =  count(node.left);
      int rightMax =  count(node.right);

        int subMax = Math.max(node.val, Math.max(leftMax,rightMax));

        if(subMax == node.val){
            cnt++;
        }
        return subMax;
        
    }
    public int countDominantNodes(TreeNode root) {
        count(root);
        return cnt;
    }
}