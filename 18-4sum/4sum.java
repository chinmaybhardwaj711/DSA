class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // int n = nums.length;
        // Arrays.sort(nums);
        // Set<List<Integer>> result = new HashSet<>();
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         for(int k=j+1;k<n;k++){
        //             for(int l=k+1;l<n;l++){
        //                 if((nums[i] + nums[j] + nums[k] + nums[l]) == target ){
        //                     result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
        //                 }

        //             }
        //         }
        //     }
        // }

        // return new ArrayList<>(result);
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1])continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1&& nums[j] == nums[j-1])continue;
                int k = j+1; int l = n-1;
               
                while(k<l){
                    long sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum<(long)target){
                        k++;
                    }else if(sum>(long)target){
                        l--;
                    }else{
                        result.add(Arrays.asList(nums[i], nums[j], nums[k],nums[l]));
                        k++;
                        l--;
                        while(k<l && nums[k] == nums[k-1])k++;
                        while(k<l && nums[l] == nums[l+1])l--;
                    }
                 }
            }
        }
        return result;
    }
}