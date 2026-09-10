class Solution {
    public int maxArea(int[] height) {
        int lp =0;
        int rp = height.length-1;
        int area =0;
        
        int maxArea =0;
        while(lp<rp){
            int width = rp-lp;
            int ht = Math.min(height[lp],height[rp]);
             area = ht*width;

            maxArea= Math.max(area,maxArea);
            if(height[lp] <height[rp]){
                lp++;
            }else{
                rp--;
            }
        }
        return maxArea;
    }
}