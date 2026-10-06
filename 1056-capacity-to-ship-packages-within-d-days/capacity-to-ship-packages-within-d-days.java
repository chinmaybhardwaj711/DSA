class Solution {
    public int check(int weights[],int x){
        int wt =0;
        int days =1;
        for(int w:weights){
            if(wt+w<=x){
                wt+=w;
            }else{
                days++;
                wt=w;
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low =0;
        int high = 0;
        for(int w:weights){
            low = Math.max(w,low);
            high+=w;
        }
       
        

        while(low<=high){
            int mid = low+(high-low)/2;
            int xdays = check(weights,mid);
            if(xdays<=days){
               
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}