class Solution {
    public void nextPermutation(int[] nums) {
      int n = nums.length;
      int piv = -1;
       for(int i=n-2;i>=0;i--){
         if(nums[i] <nums[i+1]){
           piv = i;
           break;

          }
        }

      if(piv == -1){
        //reverse array
        int start =0;  int last = n-1;
        while(start<last){
          int temp = nums[start];
          nums[start] = nums[last];
          nums[last] = temp;
          start++;
          last--;
        }
        return;
      }


     for(int i= n-1;i>=0;i--){
       if(nums[i] > nums[piv]){
        //swaap
            int temp2 = nums[i];
            nums[i] = nums[piv];
            nums[piv] = temp2; 
            break;
        }
      }

    //step 3
        int start = piv+1; int end = n-1;
        while(start<end){
           int temp = nums[start];
           nums[start] = nums[end];
           nums[end] = temp;

           start++; end--;
        }
    }   
}







  //     int n = nums.length;
    //     int piv =-1;
    //  for(int i=n-2;i>=0;i--){
    //     if(nums[i] < nums[i+1]){
    //         piv = i;
    //         break;
    //     }
        
    //  }
    //   if(piv ==-1){
    //         int start = 0;int last = n-1;
    //         while(start<last){
    //             int temp2 = nums[start];
    //             nums[start] = nums[last];
    //             nums[last] = temp2;

    //             start++;last--; 
                
    //         }
    //         return;
    // }

    // for(int i=n-1;i>piv;i--){
    //     if(nums[i] > nums[piv]){
    //         int temp = nums[i];
    //         nums[i] = nums[piv];
    //         nums[piv] = temp;
    //         break;
    //     }
    // }
    // int start = piv+1; int last = n-1;
    // while(start<last){
    //    int temp1 = nums[start];
    //     nums[start] = nums[last];
    //     nums[last] = temp1;

    //     start ++;
    //     last--;
    // }

