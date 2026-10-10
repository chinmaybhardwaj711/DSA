class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int cnt =0;
        double x =(double)a/b;
        int n = nums.length;
        for(int i=0;i<n;i++){
                int e=0;
                int o=0;
            for(int j=i;j<n;j++){
                if(nums[j]%2 == 0){
                    e++;
                }else{
                    o++;
                }
                if( o>0 && (double)e/o <=x){
                cnt++;
                }
            }
         
            
        }
        return cnt;
    }
}