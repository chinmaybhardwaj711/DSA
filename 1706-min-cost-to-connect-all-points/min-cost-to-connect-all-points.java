// class Solution {
//     static class Pair implements Comparable<Pair>{
//         int wt;
//         int node;
//         public Pair(int w, int n){
//             this.wt = w;
//             this.node = n;
//         }

//         public int compareTo(Pair p2){
//            return this.wt-p2.wt;
//         }
//     }

//     public int manhatten(int points[][], int p1, int p2){
//         return Math.abs(points[p1][0] - points[p2][0]) + Math.abs(points[p1][1] - points[p2][1]);
//     }
//     public int minCostConnectPoints(int[][] points) {
//         int n = points.length;
//         boolean mstSet[] = new boolean[n];
//         int mstCost = 0;

//         PriorityQueue<Pair> pq = new PriorityQueue<>();
//         pq.add(new Pair(0,0));

//         while(!pq.isEmpty()){
//             Pair curr = pq.remove();
//             int node = curr.node;
//             int wt = curr.wt;

//             if(mstSet[node])continue;

//             mstSet[node] = true;
//             mstCost += wt;
//             for(int i=0;i<n;i++){
//                 if(!mstSet[i]){
//                     int dist = manhatten(points,node,i);
//                     pq.add(new Pair(dist,i));
//                 }
//             }
//         }
//         return mstCost;
//     }
// }

class Solution {
    public int par[];
    public int rank[];
    public int find(int x){
        if(par[x] == x){
            return x;
        }
        par[x] = find(par[x]);
        return par[x];
    }

    public boolean union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA ==  rootB){
            return false;
        }

        if(rank[rootA] >rank[rootB]){
            par[rootB] = rootA;

        }else if(rank[rootA] <rank[rootB]){
            par[rootA] = rootB;
        }else{
            par[rootA] = rootB;
            rank[rootB]++;
        }
        return true;
    }
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        par = new int[V];
        rank = new int[V];
        for(int i=0;i<points.length;i++){
            par[i] = i;
            rank[i] = 0;
        }
        
        List<int[]> edges = new ArrayList<>();

        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int cost = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                edges.add(new int[]{i,j,cost});
            }
        }

        Collections.sort(edges,(a,b)->Integer.compare(a[2],b[2]));

       int cnt =0;
       int minCost =0;

       for(int i=0;cnt<V-1;i++){
        int [] edge = edges.get(i);
        int u = edge[0];
        int v = edge[1];
        int cost = edge[2];

        int rootA = find(u);
        int rootB = find(v);
            if(rootA != rootB){
                union(u,v);
                minCost+=cost;
                cnt++;
            }
        }
        return minCost;
    }
    
}
