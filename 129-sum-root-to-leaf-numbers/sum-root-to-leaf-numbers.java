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
    public  int sum =0;
    public void dfs(TreeNode root, int digit){
        if(root== null){
            return ;
        }
    
        digit = digit*(10)+root.val;
        if(root.left == null && root.right==null){
            sum+=digit;
            return;
        }
        dfs(root.left,digit);
        dfs(root.right,digit);

    }
    public int sumNumbers(TreeNode root) {
        int digit = 0;
        dfs(root,digit);
        return sum;
    }
}