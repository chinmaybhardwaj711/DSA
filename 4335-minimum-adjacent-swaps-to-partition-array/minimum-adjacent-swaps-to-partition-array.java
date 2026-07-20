class Solution {
    long mod = (int)1e9+7;
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        long ans =0;
        long cntM = 0;
        long cntR = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] <a){
                ans+= (cntM+cntR);
            }else if(nums[i] <=b){
                ans+= cntR;
                cntM++;
            }else{
                cntR++;
            }

        }
        return (int)(ans % mod);
    }
}