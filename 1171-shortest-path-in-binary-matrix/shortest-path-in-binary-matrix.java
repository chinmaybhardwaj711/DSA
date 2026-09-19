// class Solution {
//     public int shortestPathBinaryMatrix(int[][] grid) {
//         int n= grid.length;
//         int m = grid[0].length;

//         if(grid[0][0] == 1){
//             return -1;
//         }
//         int dir[][] = {{-1,-1},{-1,1},{1,1},{1,-1},{1,0},{-1,0}, {0,1},{0,-1}};
        
//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[]{0,0,1});
//         while(!q.isEmpty()){
//             int[] curr = q.poll();
//             int row = curr[0];
//             int col = curr[1];
//             int dist = curr[2];
//             if(row==n-1 && col == m-1){
//                 return dist;
//             }

//             for(int neigh[]:dir){
//                 int nr = row + neigh[0];
//                 int nc = col + neigh[1];

//                 if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc] == 0){
//                     grid[nr][nc] = 1;
//                     q.offer(new int[]{nr,nc,dist+1});
//                 }
        
//             }
//         }
//         return -1;
//     }
// }
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1){
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        int dir[][] = {{-1,-1},{-1,1},{1,-1},{1,1},{0,1},{0,-1},{1,0},{-1,0}};
       while(!q.isEmpty()){
        int curr[] = q.poll();
        int row = curr[0];
        int col = curr[1];
        int dist = curr[2];
        if(row==n-1 && col == m-1){
            return dist;
        }

        for(int neigh[]:dir){
            int nr = row+neigh[0];
            int nc = col+neigh[1];

            if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc] == 0){
                grid[nr][nc] = 1;
                q.offer(new int[]{nr,nc,dist+1});
            }
        }

        
       }
       return -1;
    }
}