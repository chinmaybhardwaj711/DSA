class Solution {
    public int space(int nums[],int n){
        int prev =nums[0];

        int prev2 =0;
        for(int i=1;i<n;i++){
            int pick = nums[i]; if(i>1){
                pick+=prev2;
            }
            int notPick = 0 + prev;

            int curr = Math.max(pick,notPick);

            prev2 = prev;
            prev = curr;

        }
        return prev;

    }
    public int rob(int[] nums) {
        int n= nums.length;
        int temp1[] = new int[n-1];
        int temp2[] = new int[n-1];
        if(n==1)return nums[0];

        for(int i=1;i<n;i++){
            temp1[i-1] = nums[i];
        } 

        for(int i=0;i<n-1;i++){
            temp2[i] = nums[i]; 
        }

        int ans1 = space(temp1,n-1);
        int ans2 = space(temp2,n-1);
        return Math.max(ans1,ans2);
    }
}