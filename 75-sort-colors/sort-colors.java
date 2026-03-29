class Solution {
    public void sortColors(int[] nums) {
        // int n = nums.length;
        // for(int i=0;i<nums.length-1;i++){
        //     for(int j=0;j<n-i-1;j++){
        //         if(nums[j]>nums[j+1] ){
        //               int temp = nums[j];
        //               nums[j] = nums[j+1];
        //               nums[j+1] = temp;
        //         }
              
        //     }
        // }


        // int low =0;
        // int mid = 0 ;
        // int high =nums.length-1;
        // while(mid<=high){
        //     if(nums[mid] == 1){
        //         mid++;
        //     }else if(nums[mid]==0){
        //       int temp = nums[mid];
        //       nums[mid] = nums[low];
        //       nums[low] = temp;

        //       low++;
        //       mid++;
        //     }else if(nums[mid] == 2){
        //       int temp = nums[mid];
        //       nums[mid] = nums[high];
        //       nums[high] = temp;


        //       high--;
        //     }
           
            
        // }

     int count0=0; 
     int count1=0;
     int count2 =0;

     for(int i=0;i<nums.length;i++){
        if(nums[i] == 0){
            count0++;
        }
        if(nums[i] == 1){
            count1++;
        }
        if(nums[i] == 2){
            count2++;
        }

     }
      int idx=0;
    for(int i=0;i<count0;i++){
        nums[idx] = 0;
        idx++;
    }
    for(int i=0;i<count1;i++){
        nums[idx] = 1;
        idx++;
    }
    for(int i=0;i<count2;i++){
        nums[idx] = 2;
        idx++;
    }

    }
   
}