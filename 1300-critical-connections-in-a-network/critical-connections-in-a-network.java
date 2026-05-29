class Solution {
    int time =0;
    List<List<Integer>> ans = new ArrayList<>();

    public void dfs(int curr, int parU, ArrayList<Integer>[]graphs,boolean vis[], int disc[], int low[]){
        vis[curr] = true;
        disc[curr] = low[curr] = time++;

        for(int neigh : graphs[curr]){
            if(!vis[neigh]){
                dfs(neigh,curr,graphs,vis,disc,low);
                low[curr] = Math.min(low[curr], low[neigh]);

                if(low[neigh] > disc[curr] ){
                    ans.add(Arrays.asList(curr,neigh));
                }
            }else if(neigh != parU){
                low[curr] = Math.min(disc[neigh],low[curr] );
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<Integer> graphs[] = new ArrayList[n];

        for(int i=0;i<n;i++){
            graphs[i] =  new ArrayList<>();
        } 

        for(List<Integer> edge : connections){
            int u = edge.get(0);
            int v = edge.get(1);

            graphs[u].add(v);
            graphs[v].add(u);
        }
        boolean vis[] = new boolean[n];
        int [] disc = new int[n];
        int low[] = new int[n];
        dfs(0,-1,graphs,vis,disc,low);
        return ans;

    }
}