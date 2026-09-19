class Solution {
    public void dfs(int r,int c,boolean vis[][],int heights[][]){
        int n = heights.length;
        int m = heights[0].length;
        vis[r][c] = true;
        int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int neigh[]:dirs){
            int nr = r+neigh[0];
            int nc = c+neigh[1];

           
            if(nr<0 || nc<0 || nr>=n || nc>=m ){
                continue;
            }
             if(vis[nr][nc] == true){
                continue;
            }
            if(heights[r][c] > heights[nr][nc]){
                continue;
            }
            dfs(nr,nc,vis,heights);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean pacific[][] = new boolean[n][m];
        boolean atlantic[][] = new boolean[n][m];

        //pacific    
        for(int i=0;i<n;i++){
            dfs(i,0,pacific,heights);
        }

        for(int j=0;j<m;j++){
            dfs(0,j,pacific,heights);
        }


        //atlantic
        for(int i=0;i<n;i++){
            dfs(i,m-1,atlantic,heights);
        }

        for(int j=0;j<m;j++){
            dfs(n-1,j,atlantic,heights);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j]  && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }

            }
        }
        return ans;
    }

}