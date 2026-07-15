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
    public void f(TreeNode root,List<List<Integer>> ans){
        if(root == null){
            return ;
        }
        

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean lefttoRight = true;
        while(!q.isEmpty()){
            int size = q.size();

            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                level.add(0);
            }
            for(int i=0;i<size;i++){
                TreeNode curr = q.remove();
               int index = (lefttoRight)? i:size-i-1;

               level.set(index,curr.val);
                if(curr.left!= null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }

            }
            lefttoRight = !lefttoRight;
            ans.add(level);
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        f(root,ans);
        return ans;

    }
}