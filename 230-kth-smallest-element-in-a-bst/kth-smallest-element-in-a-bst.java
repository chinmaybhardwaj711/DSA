// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     int cnt =0;
//     TreeNode ans = null;
//     public int kthSmallest(TreeNode root, int k) {
//         TreeNode node = root;
//         helper(node,k);
//         return ans.val;
//     }
//     public void helper(TreeNode node,int k){
//         if(node == null){
//             return;
//         }
//         helper(node.left,k);
//         cnt++;
//         if(cnt == k){
//             ans = node;
//             return;
//         }
//         helper(node.right,k);

//     }
// }\

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
    public void helper(TreeNode root,int k){
        if(root == null){
            return;
        }

        helper(root.left,k);
        cnt++;
        if(cnt ==k){
            ans = root;
            return;
        }
        helper(root.right,k);
    }

    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return ans.val;

         
    }

}