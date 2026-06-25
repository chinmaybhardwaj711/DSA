class Solution {
    public boolean isSafe(char board[][], int row, int col,char c){
        
        //row 
        for(int i=0;i<9;i++){
            if(board[row][i] == c)return false;  
        }

        //col
        for(int j=0;j<9;j++){
            if(board[j][col] == c )return false;
        }

        int nxtrow = 3*(row/3);
        int nxtcol = 3*(col/3);
        for(int k=0;k<3;k++){
            for(int l=0;l<3;l++){
                if(board[nxtrow+k][nxtcol+l] == c)return false;
            }
        }
        return true;
    }
    public boolean helper(char[][]board){


        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == '.'){
                    for(char c='1';c<='9';c++){
                        if(isSafe(board,i,j,c)){
                            board[i][j] = c;

                            if(helper(board)){
                                return true;
                            }
                            board[i][j] = '.';

                        }
                    }
                     return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
         helper(board);
    }
}