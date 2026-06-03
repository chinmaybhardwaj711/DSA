class Solution {
    int[] par;
    int[] rank;
   

    public int find(int x){
        if(par[x] == x){
            return x;
        }
        return par[x] = find(par[x]);
    }

    public void union(int a,int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]){
            par[parA] = parB;
            rank[parB]++;
        }else if(rank[parA] > rank[parB]){
            par[parB] = parA;
        }else{
            par[parA] = parB;
        }
    }

           
        
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        par = new int[n+1];
        rank = new int[n+1];

        for(int i=1;i<=n;i++){
            par[i] = i;
        }
        for(int i=0;i<n;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(find(u) != find(v)){
                union(u,v);
            }else{
                return new int[]{u,v};
            }

        }

        return new int[0];


    }
}