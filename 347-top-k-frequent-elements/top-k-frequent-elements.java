class Solution {
    public class Node implements Comparable<Node>{
        int num;
        int cnt;
        public Node(int num,int cnt){
            this.num = num;
            this.cnt = cnt;
        }
        public int compareTo(Node p){
            return p.cnt-this.cnt;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
            pq.add(new Node(entry.getKey(),entry.getValue()));
        }

        int ans[] = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll().num;
        }

        return ans;
    }
}