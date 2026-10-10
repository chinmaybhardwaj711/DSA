// class Solution {
//     public int findTheCity(int n, int[][] edges, int distanceThreshold) {
//       int dist[][] = new int[n][n];
//       for(int i=0;i<n;i++){
//         for(int j=0;j<n;j++){
//             dist[i][j] = Integer.MAX_VALUE;
//         }
//       }


//       for(int i=0;i<edges.length;i++){
//         int u = edges[i][0];
//         int v = edges[i][1];
//         int wt = edges[i][2];

//         dist[u][v] = wt;
//         dist[v][u] = wt;
//       }

//       for(int i=0;i<n;i++)dist[i][i] = 0;

//       for(int k=0;k<n;k++){
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE )continue;

//                 dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
//             }
//         }
//       }

//       int cntCity = n;
//       int cy = -1;

//       for(int city =0;city<n;city++){
//         int count =0;
//         for(int adjcity =0;adjcity<n;adjcity++){
//             if(dist[city][adjcity] <= distanceThreshold){
//                 count++;
//             }
//         }

//         if(count <=cntCity){
//             cntCity = count;
//             cy = city; 
//         }
//       }

//       return cy;
 
//     }
// }
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][]  = new int[n][n];
        for(int row[]:dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            dist[i][i] = 0;
        }
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = Math.min(dist[u][v],wt);
            dist[v][u] = Math.min(dist[v][u],wt);
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
        int minCnt =Integer.MAX_VALUE;
        int ans =-1;
       
        for(int i=0;i<n;i++){
            int cnt =0;
            for(int j=0;j<n;j++){
                if(dist[i][j] <=distanceThreshold){
                    cnt++;
                }
            }

            if(cnt<=minCnt){
                minCnt = cnt;
                ans = i;
            }
        }
        return ans;


    }
}