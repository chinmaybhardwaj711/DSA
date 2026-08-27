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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> inorder = new ArrayList<>();
    //     TreeNode node = root;
    //     while(true){
    //         if(node != null){
    //             st.push(node);
    //             node = node.left;
    //         }else{
    //             if(st.isEmpty()){
    //                 break;
    //             }
    //             node = st.pop();
    //             inOrder.add(node.val);
    //             node = node.right;
    //         }
    //     }
    // return inOrder;






    TreeNode curr = root;
    while(curr!=null){
        if(curr.left==null){
            inorder.add(curr.val);
            curr = curr.right;
        }else{
           TreeNode prev = curr.left;
            while(prev.right != null && prev.right!=curr){
                prev = prev.right;
            }
            if(prev.right!=curr){
                prev.right = curr;
                curr = curr.left;
            }else{
                prev.right = null;
                inorder.add(curr.val);
                curr = curr.right;
            }
        }
    }
    return inorder;
    }



}