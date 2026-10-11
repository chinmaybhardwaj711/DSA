class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = (int)1e7;
        int n = dist.length;
       
        int ans =-1;
        if(hour<=n-1){
            return -1;
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(canReach(dist,mid,hour)){
                ans =mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean canReach(int dist[],int mid,double hour){
        double time =0;
        int n = dist.length;
        for(int i=0;i<dist.length-1;i++){
           time += (dist[i]+mid-1)/mid;
        }
        time+=(double)dist[n-1]/mid;
        return time<=hour;
    }
}