class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high =0;
        int n = nums.length;
        if(n<k){
            return 0;
        }
        for(int num:nums){
            low = Math.max(low,num);
            high+=num;
        }

        while(low<=high){
            int mid = low+(high-low)/2;
            if(check(nums,mid,k)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
     
    }
    public boolean check(int nums[],int mid,int k){
        int currSum =0;
        int subarray =1;
        for(int num:nums){
           currSum+=num;
           if(currSum>mid){
            subarray++;
            currSum=num;
           }
        }
        return subarray<=k;
    }
}