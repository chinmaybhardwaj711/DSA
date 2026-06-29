class Solution {
    public int f(int i,int j,String s,String t,int [][]dp){
        //base case
        if(i==0)return 0;
        if(j==0)return 1;
        if(dp[i][j] !=-1)return dp[i][j];
        if(s.charAt(i-1) == t.charAt(j-1)){
            return dp[i][j] = f(i-1,j-1,s,t,dp)+f(i-1,j,s,t,dp);
        }else{
            return dp[i][j] =f(i-1,j,s,t,dp);
        }
          
        
       
        
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n+1][m+1];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }\
    


      int[]prev = new int[m+1];

    //    for(int i=0;i<=n;i++){
    //     dp[i][0] =1;
    //    }
        prev[0] =1;
        // for(int j=1;j<=m;j++){
        //     dp[0][j] =0;
        // }
        for(int i=1;i<=n;i++){
            int curr[] = new int[m+1];
            curr[0] =1;
            
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                   curr[j] = prev[j-1]+prev[j];
                }else{
                     curr[j] =prev[j]; 
                }
                
            }

            prev=curr;
        }
        
        return prev[m];
    }
}