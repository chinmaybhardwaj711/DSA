class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int start[] = new int[n];
        int end[] = new int[n];

        for(int i=0;i<n;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int end_ptr =0; 
        int active=0;
        int ans =0;
        int start_ptr =0;
        while(start_ptr <n){
            if(start[start_ptr] <=end[end_ptr]){
                active++;
                start_ptr++;
                ans = Math.max(ans,active);
            }else{
                active--;
                end_ptr++;
            }
        }

        return ans;
    }
}