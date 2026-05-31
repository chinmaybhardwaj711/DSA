class Solution {
    static class Pair implements Comparable<Pair>{
        int wt;
        int node;
        public Pair(int w, int n){
            this.wt = w;
            this.node = n;
        }

        public int compareTo(Pair p2){
           return this.wt-p2.wt;
        }
    }

    public int manhatten(int points[][], int p1, int p2){
        return Math.abs(points[p1][0] - points[p2][0]) + Math.abs(points[p1][1] - points[p2][1]);
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean mstSet[] = new boolean[n];
        int mstCost = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int node = curr.node;
            int wt = curr.wt;

            if(mstSet[node])continue;

            mstSet[node] = true;
            mstCost += wt;
            for(int i=0;i<n;i++){
                if(!mstSet[i]){
                    int dist = manhatten(points,node,i);
                    pq.add(new Pair(dist,i));
                }
            }
        }
        return mstCost;
    }
}