class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low =1;
        int high = 0;
        for(int num:nums){
            high = Math.max(high,num);
        }
        int ans =0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(canGive(nums,mid,maxOperations)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean canGive(int nums[], int mid, int maxOperations){
        long operations =0;
        for(int num:nums){
            operations += (num-1)/mid;
        }
        return operations<=maxOperations;
    }
}