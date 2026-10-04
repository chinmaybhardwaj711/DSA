class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low =0;
        int high = 0;
        int n = weights.length;
        for(int i=0;i<n;i++){
            low = Math.max(low,weights[i]);
            high +=weights[i];
        }
        int ans =0;

        while(low<=high){
            int mid = low+(high-low)/2;
            int tdays = check(mid,weights);
            if(tdays<=days){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    public int check(int mid,int weights[]){
        int days =1;
        int wt =0;
        for(int i=0;i<weights.length;i++){
            if(wt+weights[i] <=mid){
                wt+=weights[i];
            }else{
                days++;
                wt = weights[i];
            }
        }
        return days;
    }













































    //     int low =0;
    //     int high =0;
    //     for(int w:weights){
    //         low = Math.max(low,w);
    //         high +=w;
    //     }
    //     int ans =0;
    //     while(low<=high){
    //         int mid = low+(high-low)/2;
    //         int tdays = check(weights,mid);
    //         if(tdays<=days){
    //             ans = mid;
    //             high = mid-1;
    //         }else{
    //             low = mid+1;
    //         }
    //     }
    //     return ans;

    // }

    // public int check(int weights[],int minwt){
    //     int days =1;
    //     int wt=0;
    //     int n = weights.length;
    //    for(int i=0;i<n;i++){
    //         if(wt+weights[i] <=minwt){
    //             wt+=weights[i];
    //         }else{
    //             days++;
    //             wt = weights[i];
    //         }
    //    }
    //     return days;
    // }
}