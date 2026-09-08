class Solution {
    public int atMax(int nums[], int k){
        if(k==0){
            return 0;
        }
        int left =0;int cnt =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int right=0;right<nums.length;right++){
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);

            while(map.size() >k){
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            
            cnt+=right-left+1;
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMax(nums,k)-atMax(nums,k-1);
    }
}