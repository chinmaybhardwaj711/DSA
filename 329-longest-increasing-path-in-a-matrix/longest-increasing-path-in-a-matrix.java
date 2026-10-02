class Solution {
    public int  dirs[][] = {{1,0},{-1,-0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int ans =0;

        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                ans = Math.max(ans,dfs(matrix,r,c,dp));
            }
        }
        return ans;
        
    }
    public int dfs(int matrix[][],int row,int col,int dp[][]){
        int best =1;

        if(dp[row][col] !=-1){
            return dp[row][col];
        }

        for(int dir[]:dirs){
            int nr = row+dir[0];
            int nc = col+dir[1];

            if(nr<0 || nr>=matrix.length || nc<0 || nc>=matrix[0].length){
                continue;
            }

            if(matrix[row][col] <matrix[nr][nc]){
                best = Math.max(best,1+dfs(matrix,nr,nc,dp));
            }
        }
        dp[row][col] = best;
        return dp[row][col];

    }
}