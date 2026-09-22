// // class Solution {
// //     public  static boolean exist(char[][] board, String word) {
// //         int m = board.length; int n = board[0].length;
// //       for(int i=0;i<m;i++){
// //         for(int j=0;j<n;j++){
// //             if(board[i][j] == word.charAt(0)){
// //                 if(dfs(board,word,i,j,0)){
// //                     return true;
// //                 }
                
// //             }
           
// //         }

// //       }
// //       return false;
// //     }

// //     public  static boolean dfs(char[][]board,String word, int i,int j, int index ){
// //         if(index == word.length())return true;
// //         if(i>=board.length || i<0 ||j<0 ||j>=board[0].length)return false;
// //         if(board[i][j] != word.charAt(index))return false;

// //         char temp = board[i][j];

// //         board[i][j] = '#';

// //         boolean found = dfs(board,word,i+1,j,index+1) ||
// //                         dfs(board,word,i-1,j,index+1) ||
// //                         dfs(board,word,i,j+1,index+1) ||
// //                         dfs(board,word,i,j-1,index+1) ;


// //         board[i][j] = temp;
// //         return found;
// //     }
// // }


// class Solution {
    
//     public boolean dfs(char[][] board, String word,int i,int j,int index){
//          int m = board.length;
//         int n = board[0].length;
//         if(i<0 || j<0 || i>=m || j>=n){
//             return false;
//         }
      
//         if(word.charAt(index) != board[i][j]){
//             return false;
//         }
//           if(index == word.length()-1){
//             return true;
//         }
//         if(board[i][j] == 'X'){
//             return false;
//         }
//         index++;
//         char temp = board[i][j];
//         board[i][j] = 'X';

     
//            boolean found =  dfs(board,word,i+1,j,index) ||  dfs(board,word,i-1,j,index)||dfs(board,word,i,j+1,index) ||  dfs(board,word,i,j-1,index);
        
//         board[i][j] = temp;
//         return found;
//     }
//     public boolean exist(char[][] board, String word) {
//         int m = board.length;
//         int n = board[0].length;
//         int index =0;
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 char ch = word.charAt(index);
//                 if(board[i][j] ==ch){
//                     if(dfs(board,word,i,j,index)){
//                         return true;
//                     }
//                 }
//             }
//         }
//         return false;

//     }
// }
class Solution {
    public boolean dfs(char board[][], int row,int col,String word,int index){
        if(row<0 || row>=board.length || col<0 || col>=board[0].length){
            return false;
        }
        if(board[row][col] == 'X'){
            return false ;
        }
       
        if(board[row][col] !=word.charAt(index)){
            return false;
        }
         if(index == word.length()-1){
            return true;
        }
        
        char temp = board[row][col];
        board[row][col] = 'X';
        boolean found = dfs(board,row+1,col,word,index+1) || dfs(board,row-1,col,word,index+1) || dfs(board,row,col+1,word,index+1) || dfs(board,row,col-1,word,index+1);
        board[row][col] =  temp;
        return  found;
        

    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int index =0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,i,j,word,index)){
                    return true;
                }
            }
        }
        return false;
    }
}