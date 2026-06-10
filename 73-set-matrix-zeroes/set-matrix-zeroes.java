class Solution {
    public void setZeroes(int[][] matrix) {  // TC: N*M
    // int col[m] = {0}  ->> matrix[0][..]
    // int row[n] = {0}  ->> matrix[..][0] 
        int n =matrix.length;
        int m = matrix[0].length;
        int col0 =1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;

                    if(j!=0){
                        matrix[0][j] = 0;
                    }else{
                        col0 = 0;
                    }
                }
            }
        }


        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
              if(matrix[i][j] !=0){
                if(matrix[i][0]==0 || matrix[0][j] ==0){
                    matrix[i][j] = 0;
                }
              } 
            }
        }


        if(matrix[0][0] ==0){
            for(int j=0;j<m;j++) matrix[0][j] = 0;
        }
        if(col0 ==0){
            for(int i=0;i<n;i++) matrix[i][0] = 0;
        }
     
    }
}





































    // int m = matrix.length;
    //     int n = matrix[0].length;
    //     boolean[] rows = new boolean[m];
    //     boolean[] cols = new boolean[n];
    //     for(int i=0;i<m;i++){
    //          for(int j=0;j<n;j++){
    //             if(matrix[i][j] == 0){
    //                 rows[i] = true;
    //                 cols[j] = true;
    //             }
    //         }
    //     } 
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             if(rows[i] == true || cols[j] == true){
    //                matrix[i][j] = 0;
    //             }
    //         }
    //     }
          
        

