class Solution {
  
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int col[] = new int[V];
        for(int i=0;i<V;i++){
            col[i] = -1;
        }

        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<V;i++){
            if(col[i] == -1){
                col[i] = 0;
                q.add(i);

                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int neigh:graph[curr]){
                        if(col[neigh] == -1){
                            int nxtCol = col[curr] ==0?1:0;
                            col[neigh] = nxtCol;
                            q.add(neigh);
                        }else if(col[curr] == col[neigh]){
                            return false;
                        }
                    }
                }
            }


        }
        return true;
   
        
       
    }
}