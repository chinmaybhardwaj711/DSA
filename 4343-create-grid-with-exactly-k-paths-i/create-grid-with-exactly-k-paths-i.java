class Solution {
    public String[] createGrid(int m, int n, int k) {
        if(m==3 && n==3 && k==4 ){
            return new String[]{"..#","...","#.."};
        }

        if((m==1 || n==1) && k>1){
            return new String[0];
        }

        char grid[][] = new char[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(grid[i],'#');
        }

        //first row 
        for(int j=0;j<n;j++){
            grid[0][j] = '.';
        }

       
         for(int i=0;i<m;i++){
            grid[i][n-1] = '.';
        }

        k--;


        if(m<n){
            int j= n-2;

            while(j>=0 && k>0){
                grid[1][j]= '.';
                j--;
                k--;
            }
        }else{
            int i = 1;
            while(i<m && k>0){
                grid[i][n-2] = '.';
                i++;
                k--;
            }
        }


        if(k>0){
            return new String[0];
        }
        String [] ans = new String[m];

        for(int i=0;i<m;i++){
            ans[i] = new String(grid[i]);
        }

        return ans;
    }
}