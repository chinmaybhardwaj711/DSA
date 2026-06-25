class Solution {
    public int f(int ind,int target,int coins[], int dp[][]){
        if(ind ==0){
            if(target%coins[0] ==0){
                return target/coins[ind];
            }else{
                return (int)1e9;
            }
        }
        if(dp[ind][target] !=-1)return dp[ind][target];
        //take //nottake
        int notTake = 0 + f(ind-1,target,coins,dp);
        int take = (int)1e9;
        if(coins[ind]<=target){
            take = 1+ f(ind,target-coins[ind],coins,dp);
        }

        return dp[ind][target] = Math.min(take,notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        // for(int row[]: dp){
        //     Arrays.fill(row,-1);
        // }
    //    int ans = f(n-1,amount,coins,dp);
    //    if(ans >=(int)1e9){
    //     return -1;
    //    }
    //    return ans;

    int [] prev = new int[amount+1];
        for(int T=0;T<=amount;T++){
            if(T % coins[0] ==0){
                 prev[T] = T/coins[0];
            }else{
                prev[T] = (int)1e9;
            }
        }       

        for(int i=1;i<n;i++){
            int curr[] = new int[amount+1];
            for(int Tar=0;Tar<=amount;Tar++){
                  int notTake = 0 + prev[Tar];
                  int take = (int)1e9;
                  if(coins[i]<=Tar){
                    take = 1+ curr[Tar-coins[i]];
                  }

                curr[Tar] = Math.min(take,notTake);
            }
            prev = curr;
        }
       int ans = prev[amount]; 
       if(ans>=(int)1e9) return -1;
       
        return ans;
       
    }
    
}