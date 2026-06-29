class Solution {
     public static int f(int i,int j,String str1,String str2,int [][]dp){
        if(i==0){
            return j;
        }
        if(j==0){
            return i;
        }
        if(dp[i][j]!=-1)return dp[i][j];

        if(str1.charAt(i-1) == str2.charAt(j-1)){
            return dp[i][j] = 0+f(i-1,j-1,str1,str2,dp);
        }else{
           return dp[i][j]= Math.min(1+f(i,j-1,str1,str2,dp),Math.min(1+f(i-1,j,str1,str2,dp),1+f(i-1,j-1,str1,str2,dp)));

        }
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
       int m = word2.length();
       int dp[][] = new int[n+1][m+1];
     
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        // return f(n,m,word1,word2,dp);



    int prev[] = new int[m+1];
     

    // for(int i=0;i<=n;i++){
    //     dp[i][0] =i;
    // }
    for(int j=0;j<=m;j++){
      prev[j] = j;
    }

    for(int i=1;i<=n;i++){
        int curr[] = new int[m+1];
       curr[0] = i;
        for(int j=1;j<=m;j++){
            if(word1.charAt(i-1) == word2.charAt(j-1)){
                 curr[j] = 0+prev[j-1];
            }else{
                 curr[j]= Math.min(1+curr[j-1],Math.min(1+prev[j],1+prev[j-1]));

            }
           
        }
         prev =curr;
       
    }
     return prev[m];

    }
}