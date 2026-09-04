class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int next[][] = new int[m][n];

        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                int lives =0;

                for(int dr=-1;dr<=1;dr++){
                    for(int dc=-1;dc<=1;dc++){
                        if(dr==0 && dc==0){
                            continue;
                        }
                        int nxtr = row+dr;
                        int nxtc = col+dc;

                        if(nxtr>=0 && nxtr<m && nxtc>=0 && nxtc<n){
                            if(board[nxtr][nxtc] == 1){
                                lives++;
                            }
                        }
                    }
                }

                if(board[row][col] == 1){
                    if(lives ==2 || lives==3){
                        next[row][col] = 1;
                    }
                }else{
                    if(lives == 3){
                        next[row][col] = 1;
                    }
                }
            }
        }
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                board[row][col] = next[row][col];
            }
        }
        
    }
}