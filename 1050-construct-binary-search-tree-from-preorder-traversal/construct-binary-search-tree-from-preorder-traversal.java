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
    public TreeNode build(int preorder[], int start,int end){
        if(start>end){
            return null;
        }

        TreeNode root = new TreeNode(preorder[start]);
        int splitIndex = end+1;
        for(int i=start+1;i<=end;i++){
            if(preorder[i] > root.val){
                 splitIndex =i;
                 break;
            }
        }

        root.left = build(preorder,start+1,splitIndex-1);
        root.right = build(preorder,splitIndex,end);

        return root;        

    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder,0,preorder.length-1);
    }
}