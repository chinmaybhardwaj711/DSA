class Solution {
    public  static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i] + nums[j] == target){
                    int ans[] = {i,j};
                    return ans;
                }

            }
             
           
        }
        int ans2[] = {-1,-1};
        return ans2;
    }

    public static void main(String args[]){
        int nums [] = {2,7,11,15};
        int sol[] = twoSum(nums,9);
       System.out.println(sol[0] + "  " + sol[1]) ;
    }
}
