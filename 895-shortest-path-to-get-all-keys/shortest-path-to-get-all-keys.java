class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int allKeys =0;
        int sr =0;
        int sc =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char c = grid[i].charAt(j);
                if(c>='a' && c<='f'){
                    allKeys |= (1<<(c-'a'));

                }
                if(c == '@'){
                    sr = i;
                    sc = j;
                }
            }
        }



        boolean vis[][][] = new boolean[m][n][64];

        Queue<int[]> q = new LinkedList<>();
        int steps =0;
        q.offer(new int[]{sr,sc,0});
        vis[sr][sc][0] = true;
        int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                int curr[] = q.poll();
                
                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];

                if(mask == allKeys){
                    return steps;
                }
                for(int neigh[]:dir){
                    int nr = r+neigh[0];
                    int nc = c+neigh[1];
                    if(nr>=m || nr<0 || nc>=n || nc<0){
                        continue;
                    }
                    char ch = grid[nr].charAt(nc);
                    if(ch == '#'){
                        continue;
                    }
                    
                    if(ch>='A' && ch<='F'){
                        int keyBit = 1<<(ch-'A');
                        if((keyBit & mask) == 0){
                            continue;
                        }
                       
                    }
                    int newMask = mask;
                    
                    if(ch>='a' && ch<='f'){
                        int key = 1<<(ch-'a');
                        newMask |=key; 
                    }
                    if(!vis[nr][nc][newMask]){
                            q.offer(new int[]{nr,nc,newMask});
                            vis[nr][nc][newMask] = true;
                    }
                }
            }
            steps++;

        }
        return -1;
    }
}