class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int sums[] = new int[n];
        int sum =0;
        for(int i=0;i<n;i++){
            sums[i]+=(nums[i]+sum);
            sum+=nums[i];
        }
        return sums;

    }
}