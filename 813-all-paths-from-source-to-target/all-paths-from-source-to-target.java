class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
      
        int n = graph.length;
        dfs(graph,0,n-1,path,ans);
        return ans;
    }
    public void dfs(int graph[][],int src,int dst, List<Integer> path, List<List<Integer>> ans){
          path.add(src);
        if(src == dst){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int neigh:graph[src]){
          
            dfs(graph,neigh,dst,path,ans);
            path.remove(path.size()-1);
        }
        
    }
}