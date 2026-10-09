// class Solution {
//     public int maximumCandies(int[] candies, long k) {
//         long low = 1;
//         long high = 0;
//         for(int candy:candies){
//             high = Math.max(high,candy);
//         }
//         long ans = 0;
//         while(low<=high){
//             long mid =low+(high-low)/2;
//             if(check(candies,mid,k)){
//                 ans = mid;
//                 low = mid+1;
//             }else{
//                 high = mid-1;
//             }
//         }
//         return(int) ans;
//     }
//     public boolean check(int candies[],long mid,long k){
//         long total =0;
//         for(int candy:candies){
//             total += candy/mid;
//         }
//         return total>=k;
//     }
// }
class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int low =1;
        int high = 0;
        for(int i=0;i<n;i++){
            high = Math.max(high,candies[i]);
        }

        int ans =0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(canGive(candies,k,mid)){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
    public boolean canGive(int candies[],long k,int mid){
        int n = candies.length;
        long total =0;
        for(int i=0;i<n;i++){
            total+=candies[i]/mid;

        }
        return total>=k;

    }
}