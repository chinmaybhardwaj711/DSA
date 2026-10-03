class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low =1;
        int high =0;
        for(int pile:piles){
            high = Math.max(high,pile);
        }
        int ans =0;

        while(low<=high){
            int mid = low+(high-low)/2;
            long totalhrs =check(piles,mid);
            if(totalhrs<=h){
                ans =mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
        
    }

    public long check(int piles[],int mid){
        long totalhr =0;
        int n = piles.length;
        for(int i=0;i<n;i++){
            totalhr += ((piles[i]+mid-1)/mid);
        }
        return totalhr;
    }
}