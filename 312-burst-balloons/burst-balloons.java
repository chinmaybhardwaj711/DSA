class Solution {
    public int f(int i,int j,int num[], int dp[][]){
        if(i>j)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        int max = Integer.MIN_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost = num[i-1] * num[ind] * num[j+1] + f(i,ind-1,num,dp) + f(ind+1,j,num,dp);
            max = Math.max(cost,max);
        }

        return dp[i][j] = max;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int num[] = new int[n+2];
        num[0] = 1;
        num[n+1] = 1;
        int dp[][] = new int[n+1][n+1];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        for(int i=1;i<=n;i++){
            num[i] = nums[i-1];
        }

        return f(1,n,num,dp);

    }
}