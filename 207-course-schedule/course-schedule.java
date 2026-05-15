class Solution {
    public boolean dfsUtil(int src,boolean[]vis,boolean[]stack,int[][] edges){
        vis[src] = true;
        stack[src] = true;

        for(int i=0;i<edges.length;i++){
            int v = edges[i][1];
            int u = edges[i][0];

            if(src == u){
                if(!vis[v] && dfsUtil(v,vis,stack,edges)){
                    return true;
                }else if(stack[v]){
                    return true;
                }
            }
        }
        stack[src] = false;
        return false;
    }
    public boolean canFinish(int n, int[][] edges) {
        boolean vis[] = new boolean[n];
        boolean stack[] = new boolean[n];

        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(dfsUtil(i,vis,stack,edges)){
                    return false;
                }
            }
        }

        return true;
    }
}