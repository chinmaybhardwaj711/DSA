class Solution {
    public int f(int ind,int transNo,int prices[],int n,int k,int dp[][]){
        if(ind ==n || transNo ==2*k){
            return  0;
        }//buy

        if(dp[ind][transNo] != -1)return dp[ind][transNo];

        if(transNo%2 ==0){
           return dp[ind][transNo] = Math.max(-prices[ind] + f(ind+1,transNo+1,prices,n,k,dp) , 0 + f(ind+1,transNo,prices,n,k,dp));
        }
            return dp[ind][transNo] = Math.max(prices[ind] +f(ind+1,transNo+1,prices,n,k,dp) , 0 + f(ind+1,transNo,prices,n,k,dp) );

        
    }
    public int maxProfit(int k, int[] prices) {
        int n =prices.length;
        // int dp[][] = new int[n][2*k];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }


        // int dp[][] = new int[n+1][2*k+1];
        int ahead[] = new int[2*k+1];

        for(int ind =n-1;ind>=0;ind--){
             int curr[] = new int[2*k+1];
            for(int transNo=2*k-1;transNo>=0;transNo--){
                if(transNo%2 ==0){
                     curr[transNo] = Math.max(-prices[ind] + ahead[transNo+1] , 0 + ahead[transNo]);
                }else{
                     curr[transNo] = Math.max(prices[ind] +ahead[transNo+1] , 0 + ahead[transNo] );
                }                    
            }
            ahead=curr;
        }
        return ahead[0];

    }
}