class Solution {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k=1;

        for(int i=1;i<n;i++){
            if(nums[i] != nums[k-1]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String args[]){
        int nums[] = {1,1,2};
        int k = removeDuplicates(nums);
        for(int i=0;i<k;i++){
            System.out.print(nums[i] + " ");
        }
    }
}
