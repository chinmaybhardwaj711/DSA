class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int n1 = series1.length;
        int n2 = series2.length;
        int i =0;
        int j =0;
        List<List<Integer>> ans = new ArrayList<>();
        while(i<n1 || j<n2){
            int t ;

            if(i==n1){
                t = series2[j][0];
            }else if(j==n2){
                t = series1[i][0];
            }else{
                t = Math.min(series1[i][0], series2[j][0]);
            }

            int x1 =0;
            if(i<n1){
                x1 = series1[i][1];
            }

            int x2 = 0;

            if(j<n2){
                x2 = series2[j][1];
            }
            ans.add(Arrays.asList(t,x1+x2));

            if(i<n1 && t == series1[i][0]){
                i++;
            }

            if(j<n2 && t == series2[j][0]){
                j++;
            }


        }
        return ans;
    }
}