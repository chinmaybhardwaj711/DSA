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
    public int pathSum(TreeNode root, int targetSum) {
     
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(0l,1);
        return dfs(root,0l,targetSum,map);
    }
    public int dfs(TreeNode root,long currSum,int targetSum,HashMap<Long,Integer> map){
      
        if(root == null){
            return 0;
        }
        currSum +=root.val;

        long needed = currSum-targetSum;
         int cnt = map.getOrDefault(needed,0);
         map.put(currSum,map.getOrDefault(currSum,0)+1);

        cnt+=dfs(root.left,currSum,targetSum,map);
        cnt+=dfs(root.right,currSum,targetSum,map);

        map.put(currSum,map.get(currSum)-1);
        return cnt;
    }
}