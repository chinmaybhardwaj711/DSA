class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> q = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1])continue;
            int j=i+1; int k=n-1;
            while(j<k){
                int sum =nums[i]+ nums[j] + nums[k];
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{
                    q.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                     while(j<k && nums[j] == nums[j-1])j++;
                     while(j<k && nums[k] == nums[k+1])k--; 
                }
               
            }

        }
        return q;
        // List<List<Integer>> q = new ArrayList<>();
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length;i++){
        //     if(i>0 &&  nums[i] == nums[i-1])continue;
        //     for(int j=i+1;j<nums.length;j++){
        //         if(j>i+1 && nums[j] == nums[j-1])continue;
        //         for(int k=j+1;k<nums.length;k++){
        //             if(k>j+1 && nums[k] == nums[k-1])continue;
        //             if(nums[i] + nums[j] + nums[k] == 0){
        //                 q.add(Arrays.asList(nums[i], nums[j], nums[k]));
        //             }
        //         }
        //     }
        // }

        // return q;
    }
}