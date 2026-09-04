// class KthLargest {
//     private PriorityQueue<Integer> minHeap =new PriorityQueue<>();
//     private int k;
//     public KthLargest(int k, int[] nums) {
//         this.k = k;
//         for(int num:nums){
//             minHeap.offer(num);

//             if(minHeap.size() >k){
//                 minHeap.poll();
//             }
//         }
//     }
    
//     public int add(int val) {
//         minHeap.offer(val);

//         if(minHeap.size() >k){
//             minHeap.poll();
//         }

//         return minHeap.peek();
//     }
// }

// /**
//  * Your KthLargest object will be instantiated and called as such:
//  * KthLargest obj = new KthLargest(k, nums);
//  * int param_1 = obj.add(val);
//  */
class KthLargest {
    public int k;
    public PriorityQueue<Integer> pq ;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq  = new PriorityQueue<>();
        for(int num:nums){
            pq.offer(num);

            if(pq.size() > k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
       while(pq.size() >k){
            pq.remove();  
       }
       return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */