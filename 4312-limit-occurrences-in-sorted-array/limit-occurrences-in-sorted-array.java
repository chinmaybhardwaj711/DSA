class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
      int n = nums.length;
        int cnt =1;
        int j= 1;
      for(int i=1;i<n;i++){
        if(nums[i] == nums[i-1]){
            cnt++;
        }else{
            cnt =1;
        }

        if(cnt<=k){
            nums[j] = nums[i];
            j++;
        }

      }
    return Arrays.copyOf(nums,j);

      

    }
}