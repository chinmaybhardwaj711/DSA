class Solution {
    public  static int[] twoSum(int[] nums, int target) {
        // int n = nums.length;
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     int comp = target-nums[i];

        //     if(map.containsKey(comp)){
        //         return new int[]{map.get(comp),i};
        //     }
        //     map.put(nums[i],i);
        // }
        // return new int[]{0};
     
        
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(nums[i] + nums[j] == target){
        //             int ans[] = {i,j};
        //             return ans;
        //         }

        //     }
             
           
        // }
        // int ans2[] = {-1,-1};
        // return ans2;
    // }

    // public static void main(String args[]){
    //     int nums [] = {2,7,11,15};
    //     int sol[] = twoSum(nums,9);
    //    System.out.println(sol[0] + "  " + sol[1]) ;
    // }

    HashMap<Integer,Integer> map = new HashMap<>();

    for(int i=0;i<nums.length;i++){
        if(map.containsKey(target-nums[i])){
            return new int[]{map.get(target-nums[i]),i};
        }
        map.put(nums[i],i);
    }
    return new int[]{-1,-1};

    }
}
