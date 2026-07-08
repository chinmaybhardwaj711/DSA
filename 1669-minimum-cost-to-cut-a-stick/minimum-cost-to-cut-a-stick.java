class Solution {
    public int f(int i,int j,ArrayList<Integer> cut, int dp[][]){
        if(i>j){
            return 0;
        }
        if(dp[i][j] != -1)return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost = cut.get(j+1) - cut.get(i-1) + f(i,ind-1,cut,dp) + f(ind+1,j,cut,dp);
            min = Math.min(cost,min);
        }
        return dp[i][j] =  min;
    }
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        ArrayList<Integer> cut = new ArrayList<>();
        // int dp[][] = new int[c+2][c+2];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        for(int x:cuts){
            cut.add(x);
        }
        cut.add(0);
        cut.add(n);
        Collections.sort(cut);
        // int c = cut.size();

        int dp[][] = new int[c+2][c+2];
        for(int i=c;i>=1;i--){
            for(int j=1;j<=c;j++){
                if(i>j)continue;
                int min = Integer.MAX_VALUE;
                for(int ind=i;ind<=j;ind++){
                    int cost = cut.get(j+1) - cut.get(i-1) + dp[i][ind-1] + dp[ind+1][j];
                    min = Math.min(cost,min);
                }
             dp[i][j] =  min;
            }
        }




        return dp[1][c];

    }
}