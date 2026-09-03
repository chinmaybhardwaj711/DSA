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
    public int moves=0;
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftbalance = dfs(root.left);
        int rightbalance = dfs(root.right);

        moves += Math.abs(leftbalance);
        moves += Math.abs(rightbalance);

        return root.val-1+leftbalance+rightbalance;
    }
    public int distributeCoins(TreeNode root) {
        dfs(root);
       return moves;
    }
}