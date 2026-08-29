class Solution {
    public boolean isBalanced(TreeNode root) {
       return height(root)!=-1;
    }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int lefth = height(root.left);
        int righth = height(root.right);
        if(lefth == -1){
            return -1;
        }
        if(righth == -1){
            return -1;
        }
        if(Math.abs(lefth-righth) >1){
            return -1;
        }
        return 1 + Math.max(lefth,righth);
    }
}