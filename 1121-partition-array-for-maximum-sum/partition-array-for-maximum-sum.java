class Solution {
    public int f(int i,int arr[], int k, int n, int dp[]){
        if(i == n){
            return 0;
        }

        int len = 0; int maxSum =Integer.MIN_VALUE;
        if(dp[i] !=-1)return dp[i];
        int maxi =Integer.MIN_VALUE;
        for(int j=i;j<Math.min(n,i+k);j++){
            len++;
            maxi = Math.max(arr[j],maxi);
            int sum = len*maxi + f(j+1,arr,k,n,dp);
            maxSum = Math.max(sum,maxSum);
        }
        return dp[i] = maxSum;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return f(0,arr,k,n,dp);
    }
}