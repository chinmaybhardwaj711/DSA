// class Solution {
//     public int maxArea(int[] height) {
//       int lp =0;
//       int maxArea =0;
//       int  rp = height.length-1;
//       while(lp<rp){
//         int wdth = rp-lp;
//         int ht = Math.min(height[lp],height[rp]);
//         int currArea = ht*wdth;
//          maxArea =Math.max(currArea,maxArea);
//        if(height[lp] <height[rp]){
//         lp++;
//        }else{
//          rp--;
//        }
//       }
//       return maxArea;
//     }
// }
class Solution {
    public int maxArea(int[] height) {
        int lp = 0;
        int rp = height.length-1;
        int maxArea = 0;
        while(lp<rp){
            int wd = rp-lp;
            int ht = Math.min(height[lp],height[rp]);
            int area = wd*ht;
            maxArea = Math.max(area,maxArea);
            if(height[lp] <height[rp]){
                lp++;
            }else{
                rp--;
            }
        }
        return maxArea;
    }
}