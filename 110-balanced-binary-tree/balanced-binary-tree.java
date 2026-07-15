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
    public int f(TreeNode root){
        if(root== null){
            return 0;
        }
        int lh = f(root.left);
        int rh = f(root.right);

        if(lh == -1)return -1;
        if(rh == -1)return -1;

        if(Math.abs(lh-rh)>1){
            return -1;
        }
        return 1 + Math.max(lh,rh);

    }
     
    public boolean isBalanced(TreeNode root) {
        return f(root) != -1;
    }
}