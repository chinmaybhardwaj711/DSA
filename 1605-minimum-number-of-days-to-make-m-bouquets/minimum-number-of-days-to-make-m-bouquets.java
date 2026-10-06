class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int low =Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        if((long)m*k >n){
            return -1;
        }
        for(int i=0;i<n;i++){
            low = Math.min(low,bloomDay[i]);
            high = Math.max(high,bloomDay[i]);
        }
        while(low<=high){
            int mid = low+(high-low)/2;
           if(canMake(bloomDay,mid,m,k)){
                high = mid-1;
           }else{
            low = mid+1;
           }
        }
        return low;

    }
    public boolean canMake(int []bloomDay,int day,int m,int k){
        int consecutive = 0;int bouquet=0;
        for(int flower:bloomDay){
            if(flower<=day){
                consecutive++;
                if(consecutive == k){
                    bouquet++;
                    consecutive=0;
                }
            }else{
                consecutive=0;
            }
        }
        return bouquet>=m;
    }
}