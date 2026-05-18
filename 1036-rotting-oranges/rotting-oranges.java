class Solution {

    public
    
    class Pair{
        int row;
        int col;
        int time;

        Pair(int row,int col,int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
     int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans=0;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = true;
                }
            }
        }

        //bfs
        while(!q.isEmpty()){
            Pair curr = q.remove();
            int i = curr.row;
            int j = curr.col;
            int time = curr.time;

            ans = Math.max(ans,time);

            if(i-1>=0 && vis[i-1][j] != true && grid[i-1][j] == 1){ //up
                q.add(new Pair(i-1,j,time+1));
                vis[i-1][j] = true;
            }
             if(j+1<m && vis[i][j+1] !=true && grid[i][j+1] == 1 ){//right
                q.add(new Pair(i,j+1,time+1));
                vis[i][j+1] = true;
            }
             if(j-1>=0 && vis[i][j-1]!= true && grid[i][j-1] ==1){//left
                q.add(new Pair(i,j-1,time+1));
                vis[i][j-1] = true;
            }
             if(i+1<n && vis[i+1][j] !=true && grid[i+1][j] ==1){
                q.add(new Pair(i+1,j,time+1));
                vis[i+1][j] = true;
            }
        }
        

        //check for fresh orange 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && vis[i][j] != true){
                    return -1;
                }
            }
        }
        return ans;
    }
}