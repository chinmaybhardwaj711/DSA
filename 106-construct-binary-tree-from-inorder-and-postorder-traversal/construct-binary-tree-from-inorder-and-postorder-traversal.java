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
    public TreeNode build(int[] postorder,int poststart,int postend,int inorder[], int instart,int inend,HashMap<Integer,Integer> map){
      
        if(postend <poststart|| inend < instart ){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postend]);
        int inroot = map.get(root.val);
        int numsleft = inroot - instart;

        root.left = build(postorder,poststart,poststart+numsleft-1,inorder,instart,inroot-1,map);
        root.right = build(postorder,poststart+numsleft,postend-1,inorder,inroot+1,inend,map);
        
        return root;

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = postorder.length;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }

       TreeNode root =  build(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
        return root;

    }
}