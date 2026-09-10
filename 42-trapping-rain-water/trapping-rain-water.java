class Solution {
    public int trap(int[] height) {
        int lp =0;
      int rp =height.length-1;

      int leftMax =0;
      int rightMax =0;
      int area =0;
      int maxArea =0;
      while(lp<rp){
        if(height[lp] <height[rp]){
            leftMax = Math.max(leftMax,height[lp]);
             area += leftMax-height[lp];
             lp++;
        }else{
            rightMax = Math.max(rightMax,height[rp]);
            area +=rightMax-height[rp];
            rp--;
        }
       
      }
      return area;
    }
}