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
     int maxi = Integer.MIN_VALUE;
    public int maxPath(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftSum = maxPath(node.left);
        int rightSum = maxPath(node.right);

        leftSum = Math.max(leftSum,0);
        rightSum = Math.max(rightSum,0);
        maxi = Math.max(maxi,leftSum+rightSum+node.val);
        return node.val + Math.max(leftSum,rightSum);
    }
    public int maxPathSum(TreeNode root) {
       
        maxPath(root);
        return maxi;

    }
}