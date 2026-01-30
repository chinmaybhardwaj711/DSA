class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int answers[] = new int[nums.length];
        answers[0] = 1;
       for(int i=1;i<nums.length;i++){
        answers[i] = answers[i-1]*nums[i-1];
        }

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answers[i] = answers[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return answers;
    }
    public static void main(String args[]){
        int nums[] = {1,2,3,4};
       System.out.print(productExceptSelf(nums)); 

    }
}