class Solution {
    public long applyOperation(long x,long k,boolean multiply){
        if(multiply){
            return x*k;
        }else{
            if(x>0){
                return x/k;
            }else{
                return -(-x/k);
            }
        }
    }
    public long solve(int nums[],int k,boolean multiply){
        int n = nums.length;
        long INF = (long)1e9;

        long dp1[] = new long[n];
        long dp2[] = new long[n];
        long dp3[] = new long[n];
        //base case
        dp1[0] = nums[0];
        dp2[0] = applyOperation(nums[0],k,multiply);
        dp3[0] = -INF;

        for(int i=1;i<n;i++){
            long normal = nums[i];
            long wanded = applyOperation(nums[i],k,multiply);

            dp1[i] = Math.max(normal,normal+dp1[i-1]);

            dp2[i] = Math.max(wanded,Math.max(dp1[i-1]+wanded,dp2[i-1]+wanded));

            dp3[i] = Math.max(dp2[i-1]+normal,Math.max(dp3[i-1]+normal,dp2[i]));
        }

        long ans = -INF;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,dp1[i]);
             ans = Math.max(ans,dp2[i]);
              ans = Math.max(ans,dp3[i]);
        }

        return ans;

    }
    public long maxSubarraySum(int[] nums, int k) {
       long ans1 =  solve(nums,k,true);
        long ans2 = solve(nums,k,false);
        return Math.max(ans1,ans2);
    }
}