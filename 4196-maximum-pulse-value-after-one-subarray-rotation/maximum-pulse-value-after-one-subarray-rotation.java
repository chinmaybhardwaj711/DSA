class Solution {
    public long maxValue(int[] nums) {
        long s =0;
        long e =0;
        long o = (long)-1e9;
        long ans =0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i%2 == 0){
                s+=nums[i];
            }else{
                s-=nums[i];
            }
            
            int k = i+1;
            if(k%2 ==0){
                ans = Math.min(ans,s-e);
                e = Math.max(s,e);
            }else{
                ans = Math.min(ans,s-o);
                o = Math.max(s,o);
            }
        }

        ans = Math.min(0L,ans);
        return s-2*ans;
        
    }
}