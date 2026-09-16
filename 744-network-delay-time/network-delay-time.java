class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:times){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v,wt});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currDist = curr[1];
            if(currDist!=dist[currNode]){
                continue;
            }
            for(int[]edge:adj.get(currNode)){
                int v = edge[0];
                int wt = edge[1];
                if(currDist + wt <dist[v]){
                    dist[v] = currDist + wt;
                    pq.offer(new int[]{v,dist[v]});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max,dist[i]);
        }
        return max;

    }
}