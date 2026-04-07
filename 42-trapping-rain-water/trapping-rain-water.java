class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lp =0;
        int rp = n-1;
        int lmax = 0;
        int rmax = 0;
        int ans =0;
        while(lp<rp){
            lmax = Math.max(height[lp], lmax);
            rmax = Math.max(height[rp], rmax);

            if(lmax<rmax){
                ans += (lmax-height[lp]);
                lp++;

            }else{
                 ans += (rmax-height[rp]);
                 rp--;
            }
           
        }
        return ans;
    //     int leftMax[] = new int[n];
    //     leftMax[0] =height[0];
    //     for(int i=1;i<n;i++){
    //         leftMax[i] = Math.max(height[i], leftMax[i-1]);
    //     }
    //       int rightMax[] = new int[n];
    //     rightMax[n-1] = height[n-1];
    //     for(int i=n-2;i>=0;i--){
    //         rightMax[i] = Math.max(height[i], rightMax[i+1]);
    //     } 
    //     int trappedWater = 0;
       
    //     for(int i=0;i<n;i++){
    //         int waterLevel = Math.min(leftMax[i], rightMax[i]);
    //         trappedWater += waterLevel-height[i];
    //     }
       
    //    return trappedWater;


    }
}