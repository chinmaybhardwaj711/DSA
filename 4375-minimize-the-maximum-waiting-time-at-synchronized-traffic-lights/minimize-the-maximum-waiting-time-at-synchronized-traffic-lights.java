class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxGreen = Integer.MIN_VALUE;
        for(int light:lights){
            maxGreen = Math.max(light,maxGreen);
        }

        int ans =0;
        for(int i=0;i<arrivalTime.length;i++){
            int r = arrivalTime[i]%period;
            if(r>=maxGreen){
                int wt = period-r;
                ans = Math.max(wt,ans);
            }
        }
        return ans;
    }
}