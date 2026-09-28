class Solution {
    public int minCost(int[][] grid) {
        
    int m = grid.length;
    int n = grid[0].length;

    int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0}};
     int dist[][] = new int[m][n];
    for(int row[]:dist){
        Arrays.fill(row,Integer.MAX_VALUE);
    }
    Deque<int[]> dq = new ArrayDeque<>();
    dq.offerFirst(new int[]{0,0});

   
    dist[0][0] = 0;

    while(!dq.isEmpty()){
        int[] curr = dq.pollFirst();
        int r = curr[0];
        int c = curr[1];
        for(int d=0;d<4;d++){
            int nr = r+dirs[d][0];
            int nc = c+dirs[d][1];
            if(nr<0 || nc<0 || nr>=m || nc>=n){
                continue;
            }

            int cost =(grid[r][c] == d+1)?0:1;

            int newCost = cost+dist[r][c];
            if(newCost<dist[nr][nc]){
                dist[nr][nc] = newCost; 
                if(cost == 0){
                    dq.offerFirst(new int[]{nr,nc});
                }else{
                    dq.offerLast(new int[]{nr,nc});
                }
            }

        }
    }

    return dist[m-1][n-1];











        // int m = grid.length;
        // int n = grid[0].length;

        // int dist[][] = new int[m][n];

        // for(int row[]:dist){
        //     Arrays.fill(row,Integer.MAX_VALUE);
        // }
        // dist[0][0] = 0;
        // Deque<int[]> dq = new ArrayDeque<>();
        // dq.offerFirst(new int[]{0,0});
        // int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        
        // while(!dq.isEmpty()){
        //     int curr[] = dq.pollFirst();
        //     int r = curr[0];
        //     int c = curr[1];

        //     for(int d=0;d<4;d++){
        //         int nr = r+ dirs[d][0];
        //         int nc = c+ dirs[d][1];
                

        //         if(nr<0 || nr>=m || nc<0 || nc>=n){
        //             continue;
        //         }
        //         int cost = (grid[r][c] == d+1)?0:1;

        //         int newCost = dist[r][c] +cost;
        //         if(newCost<dist[nr][nc]){
        //             dist[nr][nc] = newCost;
        //             if(cost ==0){
        //                 dq.offerFirst(new int[]{nr,nc});
        //             }else{
        //                 dq.offerLast(new int[]{nr,nc});
        //             }
        //         }
        //     }

        // }
        // return dist[m-1][n-1];




    }

}