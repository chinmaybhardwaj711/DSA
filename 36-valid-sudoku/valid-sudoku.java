class Solution {
    public boolean check(int row,int col,char[][] board){
        //row wise
        int j=0;
        char x = board[row][col];
        while(j<board[0].length){
            if( j!=col && board[row][j] ==x){
                return false;
            }
            j++;
        }

        int i=0;
        while(i<board.length){
          
            if( i !=row && board[i][col] ==x){
                return false;
            }
            i++;
        }
        int startrow = (row/3)*3;
        int startcol = (col/3)*3;

        for(int p=startrow;p<startrow+3;p++){
            for(int q=startcol;q<startcol+3;q++){
                if(p== row && q== col){
                    continue;
                }
                if( board[p][q] == x){
                    return false;
                }
            }
        }

        return true;


        
    }
    public boolean isValidSudoku(char[][] board) {
        int m = 9;
        int n = 9;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(board[row][col] != '.'){
                    if(!check(row,col,board)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}