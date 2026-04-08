class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

    int n = nums.length;
    List<Integer> result = new ArrayList<>();
    Deque<Integer> dq = new LinkedList<>();
    //first window
    for(int i=0;i<k;i++){
        while(dq.size()>0 && nums[i] >nums[dq.getLast()]){
            dq.removeLast();
        }
        dq.addLast(i);
    }

    for(int i=k;i<n;i++){
        result.add(nums[dq.getFirst()]);

        //remvoving el not in window
        while(dq.size()>0 && dq.getFirst()<=i-k){
            dq.removeFirst();
        }

        while(dq.size()>0 && nums[dq.getLast()] <nums[i]){
            dq.removeLast();
        }
        dq.addLast(i);
    }
    result.add(nums[dq.getFirst()]);




     int []res = new int [result.size()];
    for(int i=0;i<result.size();i++){
        res[i] = result.get(i);
    }

    return res;
    }

   

  
}