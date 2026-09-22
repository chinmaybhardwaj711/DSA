class Solution {
    public void dfs(int [][]isConnected,boolean vis[],int city){
        vis[city] = true;

        for(int j=0;j<isConnected[city].length;j++){
            if( !vis[j] && isConnected[city][j] == 1){
                dfs(isConnected,vis,j);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean vis[] = new boolean[n];
        int cities =0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(isConnected,vis,i);
                cities++;
            }
        }
         return cities;
    }
   
}