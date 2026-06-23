class Solution {
       public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;

        //  boolean dp[][] = new boolean[n][target+1];
        boolean prev[] = new boolean[target+1];
        

   
    prev[0] = true;
     if(arr[0] <= target){
        prev[arr[0]] = true;
     }

       for(int i=1;i<n;i++){
       boolean  curr[] = new boolean[target+1];
        curr[0] = true;
        for(int tar=1;tar<=target;tar++){
             boolean Notake =prev[tar];
             boolean take = false;
            if(arr[i] <=tar){
               take =prev[tar-arr[i]];
            }
            curr[tar]= (take||Notake);

           
        }
        prev = curr;

       }
       return prev[target] ;


    }
    public boolean canPartition(int[] nums) {
         int sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        int target = sum/2;
        if(sum %2 !=0){
            return false;
        }
      return isSubsetSum(nums,target); 
    }
}