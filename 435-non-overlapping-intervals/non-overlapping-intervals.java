// class Solution {
//     public int eraseOverlapIntervals(int[][] intervals) {
//         int n = intervals.length;
//         Arrays.sort(intervals,(a,b)->a[0]-b[0]);
//         int start = intervals[0][0];
//         int cnt =0;
//         int end = intervals[0][1];
//         for(int i=1;i<n;i++){
//             if(end <=intervals[i][0] || start >=intervals[i][1]){
//                 end = intervals[i][1];
//             }else{
//                 cnt++;
//                 end = Math.min(end,intervals[i][1]);
//             }
//         }
//         return cnt;
//     }
// }class Solution {
   class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int end = intervals[0][1];
        int i=1;int cnt =0;
        while(i<n){
            if(end<=intervals[i][0]){
                end = intervals[i][1];
                i++;
                
            }else{
                cnt++;
                 end = Math.min(end,intervals[i][1]);
                 i++;
            }
        
        }
        return cnt;

            
    }
}