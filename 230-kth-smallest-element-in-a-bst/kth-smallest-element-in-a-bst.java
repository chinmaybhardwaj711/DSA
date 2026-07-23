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
    TreeNode ans = null;
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = root;
        helper(node,k);
        return ans.val;
    }
    public void helper(TreeNode node,int k){
        if(node == null){
            return;
        }
        helper(node.left,k);
        cnt++;
        if(cnt == k){
            ans = node;
            return;
        }
        helper(node.right,k);

    }
}