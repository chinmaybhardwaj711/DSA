class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        int end = points[0][1];
        int i=1;
        int cnt =1;
        while(i<n){
            if(end<points[i][0]){
                cnt++;
                end = points[i][1];
            }else{
                end = Math.min(end,points[i][1]);
            }
            i++;
        }
        return cnt;
    }
}