class Solution {
    public class Node{
        Node links[] = new Node[2];

        public Node(){

        }
        boolean containsKey(int bit){
            return links[bit] !=null;
        }
        void put(int bit,Node node){
            links[bit] = node;
        }
        Node get(int bit){
            return links[bit];
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
                int bit = (num>>i)&1;
                if(!node.containsKey(bit)){
                  node.put(bit,new Node());
                    
                }
                node = node.get(bit);
            }
        }

        int getMax(int num){
            Node node = root;
            int maxNum =0;
            for(int i=31;i>=0;i--){
                int bit = (num>>i)&1;
                if(node.containsKey(1-bit)){
                    maxNum = maxNum |(1<<i);
                    node = node.get(1-bit);
                }else{
                    node = node.get(bit);
                }
            }
            return maxNum;
        }

    }
    
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        int q = queries.length;
        int [][] offlineQueries = new int[q][3];

        for(int i=0;i<q;i++){
            offlineQueries[i][0] = queries[i][0];
            offlineQueries[i][1] = queries[i][1];
            offlineQueries[i][2] = i;
        }


        Arrays.sort(offlineQueries,(a,b)->a[1]-b[1]);
        int j=0;
        Trie obj = new Trie();
        int ans[] = new int[q];
        for(int i=0;i<q;i++){
            int x = offlineQueries[i][0];
            int m = offlineQueries[i][1];
            int index = offlineQueries[i][2];

            while(j<nums.length && nums[j] <=m){
                obj.insert(nums[j]);
                j++;
            }

            if(j==0){
                ans[index] = -1;
            }else{
                ans[index] = obj.getMax(x);
            }
        }
        return ans;
    }
}