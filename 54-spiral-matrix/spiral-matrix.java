class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int sr=0;
        int er=matrix.length-1;
        int sc=0;
        int ec=matrix[0].length-1;
        List<Integer> ans = new ArrayList<>();

        while(sr<=er && sc<=ec){

            //right
            for(int i=sc;i<=ec;i++){
                ans.add(matrix[sr][i]); 
            }
            sr++;
            //down
               for(int j=sr;j<=er;j++){
                ans.add(matrix[j][ec]);
            }
            ec--;
            //left
            if(sr<=er){
                for(int k=ec;k>=sc;k--){
                    ans.add(matrix[er][k]);
                }
                er--;
            }

            //up
            if(sc<=ec){
                   for(int l=er;l>=sr;l--){
                     ans.add(matrix[l][sc]);
                    }
                    sc++;
            }


        }

        return ans;
    }
}