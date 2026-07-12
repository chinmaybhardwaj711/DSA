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
    public class Pair{
        TreeNode node;
        long index;
        public Pair(TreeNode node,long index){
            this.node = node;
            this.index = index;
        }
    }
    

       

    
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root,0));
         int ans =0;
        while(!q.isEmpty()){
            int size = q.size();
            long minIndex = q.peek().index;
            long first =0;
            long last =0;
           
            for(int i=0;i<size;i++){
                Pair curr = q.poll();
                long currIndex = curr.index-minIndex;
                if(i==0){
                    first = currIndex;
                }
                if(i==size-1){
                    last = currIndex;
                }
                TreeNode curnode = curr.node;
             
             if(curnode.left != null){
                q.offer(new Pair(curnode.left,2* currIndex +1));
             }
              if(curnode.right != null){
                q.offer(new Pair(curnode.right,2*currIndex+2));
             }            
            }
            ans = Math.max(ans,(int)(last-first+1));
        }

        return ans;
    }
}