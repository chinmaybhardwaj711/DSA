class Solution {

    public boolean isSafe(char[][] board,int row, int col, int number){
        //horizontal 
        for(int i=0;i<board[0].length;i++){
            if(board[row][i] == (char)(number+'0')){
                return false;
            }
        }
        //verticaly
        for(int j=0;j<board.length;j++){
             if(board[j][col] == (char)(number+'0')){
                return false;
            }
        }

        //grid
        int sr = (row/3)*3;
        int sc = (col/3)*3;

        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j] == (char)(number+'0')){
                    return false;
                }
            }
        }

        return true;

    }
    public boolean helper(char[][] board,int row,int col){
        if(row == 9){
            return true;
        }
        int nxtRow = row; int nxtCol= col+1;
        if(nxtCol == 9){
            nxtCol = 0;
            nxtRow = row+1;
        }

        if(board[row][col] != '.'){
            return helper(board,nxtRow,nxtCol);
        }

        for(int i=1;i<=9;i++){
            if(isSafe(board,row,col,i)){
                board[row][col] = (char)(i+'0');
                if(helper(board,nxtRow,nxtCol)){
                    return true;
                }else{
                    board[row][col] = '.';
                }
           
            }
        }
        return false;
        
    }
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
}