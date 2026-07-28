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
    public class NodeVal{
        int newMin;
        int newMax;
        int sum;

        public NodeVal(int newMin,int newMax,int sum){
            this.newMin = newMin;
            this.newMax = newMax;
            this.sum = sum;
        }


    }
    public int ans =0;

    public NodeVal maxSum(TreeNode root){
        if(root == null){
            return new NodeVal(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        NodeVal left = maxSum(root.left);
        NodeVal right = maxSum(root.right);

        if(root.val >left.newMax && root.val<right.newMin){
            int currSum = root.val + left.sum + right.sum;
            ans = Math.max(currSum,ans);
            return new NodeVal(Math.min(root.val,left.newMin), Math.max(root.val,right.newMax),currSum);
        }

        return new NodeVal(Integer.MIN_VALUE,Integer.MAX_VALUE,0);

    }
    public int maxSumBST(TreeNode root) {
         maxSum(root);
         return ans;
        
    }
}