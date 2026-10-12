class Solution {
    int par[];
    int size[];
    public int makeConnected(int n, int[][] connections) {
        par = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            par[i] = i;
            size[i] = 1;
        }
        int components =n;
        if(n-1>connections.length){
            return -1;
        }
        for(int connection[]:connections){
            int u = connection[0];
            int v = connection[1];


            if(union(u,v)){
                components--;
            }
            
           
        }
        return components-1;

        
    }
    public boolean union(int a,int b ){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB){
            return false;
        }
        if(size[rootA] >size[rootB]){
            par[rootB] = rootA;
            size[rootA] += size[rootB];
        }else{
            par[rootA] = rootB;
            size[rootB] +=size[rootA];
        }
        return true;

    }
    public int find(int x){
        if(par[x] == x){
            return x;
        }
        par[x] = find(par[x]);
        return par[x];
    }
}