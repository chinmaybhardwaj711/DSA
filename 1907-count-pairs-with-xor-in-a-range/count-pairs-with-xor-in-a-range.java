class Solution {
    public class Node{
        Node links[] = new Node[2];
        int count =0;
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
            for(int i=14;i>=0;i--){
                int bit = (num>>i) & 1;
                if(!node.containsKey(bit)){
                    node.put(bit,new Node());
                }
                node = node.get(bit);
                node.count++;
            }
            
        }

        int getMax(int num){
            Node node = root;
            int maxNum = 0;
            for(int i=14;i>=0;i--){
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
         int countLessthan(int x,int k){
        Node node = root;
        int cnt =0;
        for(int i=14;i>=0;i--){
             int xbit = (x>>i)&1;
             int kbit = (k>>i)&1;

             if(kbit == 0){
                if(!node.containsKey(xbit)){
                    return cnt;
                }
                node = node.get(xbit);
             }else{
                if(node.containsKey(xbit)){
                    cnt+=node.get(xbit).count;
                }
                if(!node.containsKey(1-xbit)){
                    return cnt;
                }
                node = node.get(1-xbit);
             }
        }
        return cnt;
    }    

    
       
    }

    public int countPairs(int[] nums, int low, int high) {
        int n = nums.length;
        Trie obj = new Trie();

        int ans =0;
        for(int num:nums){
            ans +=obj.countLessthan(num,high+1)-obj.countLessthan(num,low);

            obj.insert(num);
        }
        return ans;

   
       
    }
}