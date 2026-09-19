// class Solution {
//     public void dfs(char board[][],int i,int j){
//         int n = board.length;
//         int m = board[0].length;

//        if(i<0 || i>=n || j<0 || j>=m){
//         return;
//        }
//        if(board[i][j] == 'O'){
//            board[i][j] = '#';
//             dfs(board,i-1,j);
//             dfs(board,i+1,j);
//             dfs(board,i,j+1);
//             dfs(board,i,j-1);
//        }
    

//     }
//     public void solve(char[][] board) {
//         int n = board.length;
//         int m = board[0].length;

//        for(int i=0;i<n;i++){
//             if(board[i][m-1] == 'O'){
//                 dfs(board,i,m-1);
//             }
//             if(board[i][0] == 'O'){
//                dfs(board,i,0);
//             }
//        }
      

//        for(int j=0;j<m;j++){
//             if(board[n-1][j] == 'O'){
//                dfs(board,n-1,j);
//             }
//              if(board[0][j] == 'O'){
//                dfs(board,0,j);
//             }
//        }

      


//        for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(board[i][j] == 'O'){
//                     board[i][j] = 'X';
//                 }
//                 if(board[i][j] == '#'){
//                     board[i][j] = 'O';
//                 }
//             }
//        }

//     }
// }
class Solution {
    public void dfs(char grid[][], int row,int col){
        int n = grid.length;
        int m = grid[0].length;


       if(row >=n ||col>=m || row<0 || col<0){
            return;
       }
        if(grid[row][col] == 'O'){
              grid[row][col] = '#';

            dfs(grid,row+1,col);
            dfs(grid,row-1,col);
            dfs(grid,row,col+1);
            dfs(grid,row,col-1);
        }
     
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++){
            if(board[i][m-1] == 'O'){
                dfs(board,i,m-1);
            }
            if(board[i][0] == 'O'){
                dfs(board,i,0);
            }
        }

        for(int j=0;j<m;j++){
            if(board[n-1][j] == 'O'){
                dfs(board,n-1,j);
            }
            if(board[0][j] == 'O'){
                dfs(board,0,j);
            }
        }      


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }

                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }  



        
    }
}