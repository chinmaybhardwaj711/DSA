class Solution {

    public void dfs(char[][] grid, int row,int col){
        //base case1 
        if(row<0|| row>=grid.length || col<0 || col>=grid[0].length|| grid[row][col] !='1'){
            return ;
        }
        

        grid[row][col] = '0';

        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
        dfs(grid,row,col-1);
        dfs(grid,row,col+1);

       

    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                        
                    
                } 
            }
        }

        return count;
    }
}