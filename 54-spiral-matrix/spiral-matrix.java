// class Solution {
//     public List<Integer> spiralOrder(int[][] matrix) {
//         int sr=0;
//         int er=matrix.length-1;
//         int sc=0;
//         int ec=matrix[0].length-1;
//         List<Integer> ans = new ArrayList<>();

//         while(sr<=er && sc<=ec){

//             //right
//             for(int i=sc;i<=ec;i++){
//                 ans.add(matrix[sr][i]); 
//             }
           
//             //down
//                for(int j=sr+1;j<=er;j++){
//                 ans.add(matrix[j][ec]);
//             }
           
//             //left
            
//                 for(int k=ec-1;k>=sc;k--){
//                     if(sr==er){
//                         break;
//                     }
//                     ans.add(matrix[er][k]);
//                 }
               
           

//             //up
            
//                    for(int l=er-1;l>=sr+1;l--){
//                     if(sc==ec){
//                         break;
//                     }
//                      ans.add(matrix[l][sc]);
//                     }
                    
//         sr++;
//         er--;
//         sc++;
//         ec--;


//         }

//         return ans;
//     }
// }
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int sr=0;
        int sc=0;
        int er = matrix.length-1;
        int ec = matrix[0].length-1;
        List<Integer> ans = new ArrayList<>();

        while(sr<=er && sc<=ec){
            //right
            for(int col=sc;col<=ec;col++){
                ans.add(matrix[sr][col]);
            }

            for(int row=sr+1;row<=er;row++){
                ans.add(matrix[row][ec]);
            }

            for(int col=ec-1;col>=sc;col--){
                if(sr==er){
                    break;
                }
                ans.add(matrix[er][col]);
            }

            for(int row=er-1;row>=sr+1;row--){
                if(sc==ec){
                    break;
                }
                ans.add(matrix[row][sc]);
            }

            sr++;
            sc++;
            er--;
            ec--;
        }
        return ans;

    }
}