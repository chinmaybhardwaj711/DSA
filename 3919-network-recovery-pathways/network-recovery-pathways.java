// class Solution {
//     public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
//         int n = online.length;

//         List<List<int[]>> adj = new ArrayList<>();

//         for(int i=0;i<n;i++){
//             adj.add(new ArrayList<>());
//         }

//         int maxCost =0;

//         for(int edge[]:edges){
//             int u = edge[0];
//             int v = edge[1];
//             int cost = edge[2];
//             if(online[u] && online[v]){
//                 adj.get(u).add(new int[]{v,cost});
//                 maxCost = Math.max(cost,maxCost);
//             }
          
//         }

//         int indeg[] = new int[n];

//         for(int i=0;i<n;i++){
//             for(int neigh[]:adj.get(i)){
//                 int v = neigh[0];
//                 indeg[v]++;
//             }
//         }

//         Queue<Integer> q = new LinkedList<>();
//         for(int i=0;i<n;i++){
//             if(indeg[i] == 0){
//                 q.offer(i);
//             }
//         }
//         List<Integer> topo = new ArrayList<>();
//         while(!q.isEmpty()){
//             int curr = q.poll();
//             topo.add(curr);
//             for(int neigh[]:adj.get(curr)){
//                 int v = neigh[0];
//                 indeg[v]--;
//                 if(indeg[v] == 0){
//                     q.offer(v);
//                 }
//             }
//         }


//         int low =0;
//         int high = maxCost;
//         int ans =-1;

//         while(low<=high){
//             int mid = low+(high-low)/2;
//                 if(check(mid,topo,adj,k)){
//                     ans = mid;
//                     low = mid+1;
//                 }else{
//                     high = mid-1;
//                 }
//         }
//         return ans;


//     }

//     public boolean check(long threshold,List<Integer> topo,List<List<int[]>> adj,long k){
//     int n = topo.size();
//         long dist[] = new long[n];
//         Arrays.fill(dist,Long.MAX_VALUE);
//         dist[0] = 0;
//         for(int u:topo){
//             if(dist[u]>k){
//             continue;
//             }

//             for(int edge[]:adj.get(u)){
//                 int v = edge[0];
//                 int wt = edge[1];

//                 if(wt<threshold){
//                     continue;
//                 }
//                 if(dist[u]+wt<dist[v]){
//                     dist[v]  = dist[u]+wt;
//                 }

//             }

//         }

//         return dist[n-1]<=k;


//     }
// }



class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int maxCost =0;
       for(int neigh[]:edges){
            int u = neigh[0];
            int v = neigh[1];
            int cost = neigh[2];
            if(online[u] && online[v]){
                adj.get(u).add(new int[]{v,cost});
                maxCost = Math.max(cost,maxCost);
            }

       }

       int indegree[] = new int[n];
       for(int i=0;i<n;i++){
        for(int edge[]:adj.get(i)){
            int v = edge[0];
            indegree[v]++;
        }
       }
       Queue<Integer> q = new LinkedList<>();

       for(int i=0;i<n;i++){
        if(indegree[i] == 0){
            q.add(i);
        }
       }
        List<Integer> topo = new ArrayList<>();
       while(!q.isEmpty()){
            int curr = q.poll();
            topo.add(curr);
            for(int neigh[]:adj.get(curr)){
                int u = neigh[0];
                indegree[u]--;
                if(indegree[u] == 0){
                    q.add(u);
                }
            }

       }


       int low =0;
       int high = maxCost;
        int ans=-1;
       while(low<=high){
            int mid = low+(high-low)/2;
            
            if(check(mid,topo,adj,k,n)){
                ans = mid;
                low = mid+1;
            }else{
                high= mid-1;
            }
       }
       return ans;





    }


    public boolean check(int mid,List<Integer> topo,List<List<int[]>>adj,long k,int n){
        long dist[] = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] =0;

        for(int u:topo){
            if(dist[u] == Long.MAX_VALUE){
                continue;
            }

            for(int neigh[]:adj.get(u)){
                int v = neigh[0];
                int wt = neigh[1];

                if(wt<mid){
                    continue;
                }
                if(dist[u] +wt <dist[v]){
                    dist[v] = dist[u]+wt;
                }

            }
        }
        return dist[n-1]<=k;
    }
}