class Solution {
    public int f(List<List<Integer>> triangle,int i,int j,int n,int dp[][]){
        if(i==n-1)return triangle.get(i).get(j);
        if(dp[i][j] !=-1){
            return dp[i][j];
        }
        int d = triangle.get(i).get(j) + f(triangle,i+1,j,n,dp);
        int dg = triangle.get(i).get(j) + f(triangle,i+1,j+1,n,dp);
        dp[i][j]=Math.min(d,dg);
        return dp[i][j];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
    //    return f(triangle,0,0,n,dp);
        for(int j=0;j<n;j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int d = triangle.get(i).get(j) + dp[i+1][j];
                int dg = triangle.get(i).get(j) +dp[i+1][j+1];


                 dp[i][j] = Math.min(d,dg);
            }
           
        }


         return dp[0][0];
    }
   
}