class Solution {

    public void dfs(char[][] grid, boolean vis[][], int row,int col){
        //base case1 
        if(row<0|| row>=grid.length || col<0 || col>=grid[0].length){
            return ;
        }
        if(grid[row][col] == '0' || vis[row][col]){
            return ;
        }
        vis[row][col] = true;
        dfs(grid,vis,row-1,col);
        dfs(grid,vis,row+1,col);
        dfs(grid,vis,row,col-1);
        dfs(grid,vis,row,col+1);

       

    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(grid,vis,i,j);
                        count++;
                    
                } 
            }
        }

        return count;
    }
}