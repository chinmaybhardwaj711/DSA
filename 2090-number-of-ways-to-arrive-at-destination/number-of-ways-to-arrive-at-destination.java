class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj   = new ArrayList<>();  
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int rows[]:roads){
            int u = rows[0];
            int v = rows[1];
            int time = rows[2];
            adj.get(u).add(new int[]{v,time});
            adj.get(v).add(new int[]{u,time});
        }

        long dist[] = new long[n];
        long ways[] = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));

        pq.offer(new long[]{0,0});

        long mod = 1000000007L;
        while(!pq.isEmpty()){
            long []curr = pq.poll();
            int u = (int)curr[0];
           if(curr[1] > dist[u]){
            continue;
           }

            for(int neigh[]:adj.get(u)){
                int v = neigh[0];
                long wt = neigh[1];
                if(dist[u]+wt <dist[v]){
                    dist[v] = dist[u] + wt;
                    pq.offer(new long[]{v,dist[v]});
                    ways[v] = ways[u];
                }else if(dist[u] + wt == dist[v]){
                    ways[v]= (ways[v]+ways[u])%mod;
                }
            }
        }
        return (int)ways[n-1];
        
    }
}