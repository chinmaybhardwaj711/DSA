class Solution {

   public boolean isSafe(char[][]board, int row,int col){
        //horizontal
        for(int c=0;c<board[row].length;c++){
            if(board[row][c] == 'Q'){
                return false;
            }
        }

        //vertical
        for(int v=0;v<board.length;v++){
            if(board[v][col] == 'Q'){
                return false;
            }
        }

        //leftup
        
        for(int r=row,c=col;r>=0 &&c>=0;r--,c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //rightup
        for(int r=row,c=col;r>=0 &&c<board.length;r--,c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //leftdown
        for(int r=row,c=col;r<board.length && c>=0;r++,c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //rightdown
        for(int r=row,c=col;r<board.length && c<board.length;r++,c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public void saveBoard(char[][] board,List<List<String>> allBoard){

        List<String> newBoard = new ArrayList<>();

        for(int i=0;i<board.length;i++){
            String row = "";
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'Q'){
                    row+= 'Q';
                }else{
                    row+= '.';
                }
            }
            newBoard.add(row);
        }

        allBoard.add(newBoard);
    }
  public void helper(char[][] board,int row,int n, List<List<String>> allBoard){
    if(row == n){
        saveBoard(board,allBoard);
        return;
    }
    for(int col=0;col<board[0].length;col++){
        if(isSafe(board,row,col)){
            board[row][col] = 'Q';
            helper(board,row+1,n,allBoard);
            board[row][col] = '.';
        }
    }
  }  
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> allBoard = new ArrayList<>();
    char[][] board = new char[n][n];
    helper(board,0,n,allBoard);

    return allBoard;
    }
}