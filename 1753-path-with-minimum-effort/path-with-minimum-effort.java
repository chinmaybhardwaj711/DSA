class Solution {
    public class Pair{
        int row;
        int col;
        int effort;
        public Pair(int row,int col,int effort){
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.effort,b.effort));

        int dist[][] = new int[m][n];
        for(int row[]: dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        pq.offer(new Pair(0,0,0));
        int dirs[][] = {{-1,0},{1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int curRow = curr.row;
            int currCol = curr.col;
            int currEffort = curr.effort;
            

            if(curRow == m-1 && currCol == n-1){
                return dist[curRow][currCol];
            }
            for(int neigh[]:dirs){
                int nr = curRow +neigh[0];
                int nc = currCol + neigh[1];
                if(nr<0 || nr>=m || nc<0 || nc>=n){
                    continue;
                }
                int dis = Math.abs(heights[curRow][currCol] - heights[nr][nc]);

                int newEffort = Math.max(dis,currEffort);

                if(newEffort < dist[nr][nc]){
                    dist[nr][nc] = newEffort;
                    pq.offer(new Pair(nr,nc,newEffort));
                }


            }


        }
        return 0;

    }
}