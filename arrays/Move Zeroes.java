class Solution {
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int k=0;
        for(int i=0;i<n;i++){
            if(nums[i] != 0){
                nums[k] = nums[i];
                k++;
            }
        }


        while(k<nums.length){
            nums[k] = 0;
            k++;
        }
        
    }

    public static void main(String args[]){
      int nums[] = {0,1,0,3,12};
      moveZeroes(nums);

      for(int i=0;i<nums.length;i++){
        System.out.print(i + " ");
      }
    }
}
