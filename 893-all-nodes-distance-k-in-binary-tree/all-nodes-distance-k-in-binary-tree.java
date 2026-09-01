/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
    List<Integer> ans = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();

                if(curr.left!=null){
                    parent.put(curr.left,curr);
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    parent.put(curr.right,curr);
                    q.offer(curr.right);
                }
            }
        }

        Queue<TreeNode> q2 = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q2.offer(target);
        visited.add(target);
        while(k>0 && !q2.isEmpty()){
            int size = q2.size();
            for(int i=0;i<size;i++){
                TreeNode temp = q2.poll();

                if(temp.left!=null && !visited.contains(temp.left)){
                    q2.offer(temp.left);
                    visited.add(temp.left);
                }
  
                if(temp.right!=null && !visited.contains(temp.right)){
                    q2.offer(temp.right);
                    visited.add(temp.right);
                }     
                if(parent.containsKey(temp) && !visited.contains(parent.get(temp))){
                    q2.offer(parent.get(temp));
                    visited.add(parent.get(temp));
                }       

            }
            k--;
        }
        while(!q2.isEmpty()){
            ans.add(q2.poll().val);
        }
        return ans;

      

    }
}