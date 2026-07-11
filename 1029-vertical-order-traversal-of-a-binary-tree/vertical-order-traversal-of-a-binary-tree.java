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
        int vertical;
        int level;
        
        public Pair(TreeNode node,int vertical, int level){
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }
    public void f(TreeNode curr,List<List<Integer>> list){
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();

        q.add(new Pair(curr,0,0));

        while(!q.isEmpty()){
            Pair temp = q.remove();
            TreeNode node = temp.node;
            int vert = temp.vertical;
            int levl = temp.level;

            if(!map.containsKey(vert)){
                map.put(vert,new TreeMap<>());
            }
            if(!map.get(vert).containsKey(levl)){
                map.get(vert).put(levl,new PriorityQueue<>());
            }
            map.get(vert).get(levl).add(node.val);

            if(node.left!= null){
                q.add(new Pair(node.left,vert-1,levl+1));
            }
            if(node.right!= null){
                q.add(new Pair(node.right,vert+1,levl+1));
            }           
        }

        for(TreeMap<Integer,PriorityQueue<Integer>> ys: map.values()){
             List<Integer> temp = new ArrayList<>();
            for(PriorityQueue<Integer> pq : ys.values()){
                while(!pq.isEmpty()){
                    temp.add(pq.poll());
                }
            }
             list.add(temp);
        }
       

        
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeNode curr = root;
        List<List<Integer>> list = new LinkedList<>();
        f(curr,list);
        return list;
    }
}