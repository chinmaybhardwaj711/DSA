class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start =0;
        int end = n-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[start] <= nums[mid]){ //left half sorted
              if(nums[start] <=target && target<=nums[mid]){
                end = mid;
              }else{
                start = mid+1;
              }
            }else{     //right half sorted
                if(nums[mid] <=target && target<=nums[end]){
                    start = mid+1;
                }else{
                    end = mid;
                }

            }
        }
        return -1;
    }  
}    
