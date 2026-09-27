// class Solution {
//     static class Edge{
//         int src;
//         int dst;
//         int wt;

//         public Edge(int s,int d, int w){
//             this.src = s;
//             this.dst = d;
//             this.wt = w;
//         }
//     }

//     static class Info{
//         int v;
//         int cost;
//         int stops;

//         public Info(int v,int c,int s){
//             this.v = v;
//             this.cost = c;
//             this.stops = s;
//         }
        
        
//     }
//     public static void createGraph(int flights[][],ArrayList<Edge> graphs[], int V){
//         for(int i=0;i<V;i++){
//             graphs[i] =  new ArrayList<>();
//         }

//         for(int i=0;i<flights.length;i++){
//             int src = flights[i][0];
//             int dst = flights[i][1];
//             int wt = flights[i][2];

//             Edge e = new Edge(src,dst,wt);
//             graphs[src].add(e);
//         }
//     }
//     public static int findCheapestPrice(int n, int flights[][], int src, int dst, int k) {
//          ArrayList<Edge> graphs[] = new ArrayList[n];
//         createGraph(flights,graphs,n);

//         int dist[] = new int[n];

//         for(int i=0;i<graphs.length;i++){
//             if(i!=src){
//                 dist[i] = Integer.MAX_VALUE;
//             }
//         }
//         Queue<Info> q = new LinkedList<>();
//         q.add(new Info(src,0,0));

//         while(!q.isEmpty()){
//             Info curr = q.remove();
//           if(curr.stops > k){
//             break;
//           }

//           for(int i=0;i<graphs[curr.v].size();i++){
//             Edge e = graphs[curr.v].get(i);
//             int u = e.src;
//             int v = e.dst;
//             int wt = e.wt;

//             if(curr.cost + wt <dist[v] && curr.stops <=k){
//                 dist[v] = curr.cost + wt;
//                 q.add(new Info(e.dst,dist[v],curr.stops+1));
//             }
//           }
//         }
//         if(dist[dst]  == Integer.MAX_VALUE){
//             return -1;
//         }else{
//            return dist[dst];
//         }
        
//     }
   
       


    
// }

class Solution {
    public class Pair{
        int u;
        int cost;
        int stops;
        public Pair(int u,int cost,int stops){
            this.u =u ;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int cost = flights[i][2];

            adj.get(from).add(new int[]{to,cost});
        }

       Queue<Pair> pq = new LinkedList<>();

        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]  =0;
        pq.offer(new Pair(src,0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int u = curr.u;
            int stops = curr.stops;
            if(stops >k){
                continue;
            }
            for(int edge[]:adj.get(u)){
                int v = edge[0];
                int wt = edge[1];

                if(curr.cost+wt<dist[v] && curr.stops <=k){
                    dist[v] = curr.cost+wt;
                    pq.offer(new Pair(v,dist[v],stops+1));
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];

    }
}