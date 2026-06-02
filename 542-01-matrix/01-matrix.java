class Solution {
    static class Node{
        int first;
        int second;
        int third;

        public Node(int f,int s,int t){
            this.first = f;
            this.second = s;
            this.third = t;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int dist[][] = new int[n][m];

        boolean vis[][] = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    q.add(new Node(i,j,0));
                    vis[i][j] = true;
                }
            }
        }

        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};

        while(!q.isEmpty()){
            Node curr = q.remove();
            int row =  curr.first;
            int col = curr.second;
            int steps = curr.third;

            dist[row][col] =steps;

            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol]){
                    q.add(new Node(nrow,ncol,steps+1));
                    vis[nrow][ncol] = true;
                }
            }
        }

        return dist;
     }
}