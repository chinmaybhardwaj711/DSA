// class Solution {
//     public int firstOccurence(int nums[],int target){
//         int n = nums.length;
//         int low = 0;
//         int high = n-1;
//         int first =-1;
//         while(low<=high){
//             int mid = low+(high-low)/2;
//             if(nums[mid] == target){
//                 first = mid;
//                 high = mid-1;
//             }else if(nums[mid] <target){
//                 low = mid+1;
//             }else{
//                 high = mid-1;
//             }
//         }
//         return first;
//     }

//     public int lastOccurence(int nums[],int target){
//         int n = nums.length;
//         int low = 0;
//         int high = n-1;
//         int last =-1;
//         while(low<=high){
//             int mid = low+(high-low)/2;
//             if(nums[mid] == target){
//                 last = mid;
//                 low = mid+1;
//             }else if(nums[mid] <target){
//                 low = mid+1;
//             }else{
//                 high = mid-1;
//             }
//         }
//         return last;
//     }

//     public int[] searchRange(int[] nums, int target) {
//         int first = firstOccurence(nums,target);
        
//         if(first == -1){
//             return new int[]{-1,-1};
//         }
//         int last = lastOccurence(nums,target);
//         return new int[]{first,last};
//     }
// }


class Solution {
    public int firstOccurence(int nums[],int target){
        int low =0;
        int high = nums.length-1;
        int ans =-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                ans = mid;
                high = mid-1;
            }else if(nums[mid] >target){
                high = mid-1;
            }else{
                low = mid+1;
            }
            
        }
        return ans;
    }

    public int lastOccurence(int nums[],int target){
        int low = 0;
        int high = nums.length-1;
        int ans =-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                ans = mid;
                low = mid+1;
            }else if(nums[mid] >target){
                high = mid-1;
            }else{
                low = mid+1;
            }
           
        }  
         return ans;     
    }
    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurence(nums,target);
        if(first == -1){
            return new int[]{-1,-1};
        }

        int last = lastOccurence(nums,target);

        return new int[]{first,last};
    }
}