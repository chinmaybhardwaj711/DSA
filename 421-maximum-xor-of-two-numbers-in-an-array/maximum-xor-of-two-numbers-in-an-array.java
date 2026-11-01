class Solution {
    public class Node{
        Node links[] = new Node[2];
        public Node(){

        }

        boolean containsKey(int ind){
            return links[ind] != null;
        }

        Node get(int ind){
            return links[ind];
        }
        void put(int ind,Node node){
            links[ind] = node;
        }
        
    }

    public class Trie{
        Node root ;
        public Trie(){
            root = new Node();
        }
        void insert(int num){
            Node node = root;
            for(int i=31;i>=0;i--){
                int bit = (num>>i) & 1;
                if(!node.containsKey(bit)){
                    node.put(bit,new Node());
                }
                node = node.get(bit);
            }
        }

        int getMax(int num){
            Node node = root;
            int maxNum = 0;
            for(int i=31;i>=0;i--){
                int bit = (num>>i)&1;
                if(node.containsKey(1-bit)){
                    maxNum = maxNum | (1<<i);
                    node = node.get(1-bit);
                }else{
                    node = node.get(bit);
                }
            }
            return maxNum;
        }

    }
    public int findMaximumXOR(int[] nums) {
        Trie obj = new Trie();

        for(int num: nums){
            obj.insert(num);
        }

        int maxNum =0;
        for(int num:nums){
            maxNum = Math.max(maxNum,obj.getMax(num));
        }
        return maxNum;
    }
}