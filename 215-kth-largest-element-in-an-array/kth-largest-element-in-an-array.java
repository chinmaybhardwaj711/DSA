class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        // for(int num:nums){
        //     pq.add(num);
        // }
        // int ans =0;
        // while(k>0){
        //     ans =pq.remove();
        //     k--;
        // }
        // return ans;




        //optimal
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums){
            pq.offer(num);

            if(pq.size()>k){
                pq.poll();
            }

        }
        return pq.peek();
    }
}