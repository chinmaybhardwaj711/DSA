class Solution {
    public void dfs(int[][] isConnected,int city,boolean vis[]){
        if(vis[city]){
            return;
        }
        vis[city] = true;

        for(int j=0;j<isConnected.length;j++){
            if(!vis[j]  && isConnected[city][j] ==1){
                dfs(isConnected,j,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int cnt =0;
        int n = isConnected.length;
        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                cnt++;
                dfs(isConnected,i,vis);
            }
            
        }
           return cnt;
    }
 
}