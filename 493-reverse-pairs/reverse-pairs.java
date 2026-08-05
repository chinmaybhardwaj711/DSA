class Solution {
   
    // public long mergeSort(int[]nums,int si,int ei){
    //     long count =0;
    //     if(si>=ei){
    //         return count ;
    //     }
    //     int mid = si+(ei-si)/2;
    //    count+= mergeSort(nums,si,mid);
    //    count+= mergeSort(nums,mid+1,ei);
    //    count+= countPairs(nums,si,mid,ei);
    //     merge(nums,si,mid,ei);
    //     return count;
    // }
    // public long countPairs(int nums[], int si, int mid, int ei ){
    //     int cnt =0;
    //     int right = mid+1;
    //     for(int i= si;i<=mid;i++){
    //         while(right<=ei && nums[i] >2L*nums[right]){
    //             right++;
               
    //         }
    //          cnt+= right-(mid+1);
    //     }
    //     return(long) cnt;
    // }

    // public void merge(int nums[], int si,int mid, int ei){
    //     int left = si;
    //     int right = mid+1;
    //     int k=0;
    //     int count =0;
    //     int[] temp = new int[ei-si+1];
    //     while(left<=mid && right<=ei){
    //         if(nums[left] >nums[right] ){
                
    //             temp[k++] = nums[right++];
               
            
               
    //         }else{
    //             temp[k++] = nums[left++];
    //         }
    //     }

    //     while(left<=mid){
    //         temp[k++] = nums[left++];

    //     }

    //     while(right<=ei){
    //         temp[k++] = nums[right++];
    //     }

    //     for(int i=si;i<=ei;i++){
    //         nums[i] = temp[i-si];
    //     }
         

    // }







    long count =0;
    public void mergeSort(int si,int ei,int nums[]){
        if(si>=ei){
            return;
        }

        int mid = si+(ei-si)/2;
          mergeSort(si,mid,nums);
        mergeSort(mid+1,ei,nums);
      
        count += countPairs(si,mid,ei,nums);
        merge(si,mid,ei,nums);

    }
    public long countPairs(int si,int mid,int ei, int nums[]){
        int right = mid+1;
        int cnt =0;
        for(int i=si;i<=mid;i++){
            while( right <=ei && nums[i] >(long) 2* nums[right]){
                right++;
            }
            cnt += right-(mid+1);
        }
        return (long) cnt;
    }

    public void merge(int si,int mid,int ei,int nums[]){
        int left = si;
        int right = mid+1;
        int cnt =0;
        List<Integer> ans = new ArrayList<>();
        while(left<=mid && right<=ei){
            if(nums[left] > nums[right]){
                ans.add(nums[right]);
                right++;
            }else{
                ans.add(nums[left]);
                left++;
            }
        }

        while(left<=mid){
            ans.add(nums[left]);
            left++;
        }

         while(right<=ei){
            ans.add(nums[right]);
            right++;
        }       

        for(int i=si ;i<=ei;i++){
            nums[i] = ans.get(i-si);
        }
   
    }
    public int reversePairs(int[] nums) {
         mergeSort(0,nums.length-1,nums);
         return (int)count;











       
       
    }



     // return (int) mergeSort(nums,0,nums.length-1);
        
    //  public static long mergeSort(int nums[], int si,int ei){
    //         if(si>=ei){
    //             return 0;
    //         }
    //         int mid = si+(ei-si)/2;
    //         long count=0;
    //         count+=mergeSort(nums, si,mid);
    //         count+=mergeSort(nums,mid+1,ei);
    //         count+= countPairs(nums,si,mid,ei);
    //         merge(nums,si,mid,ei);

    //         return (long) count;
    //     }

        // public static long countPairs(int nums[], int si,int mid,int ei){
        //     int j=mid+1;
        //     int count =0;
            
        //     for(int i=si;i<=mid;i++){
        //         while(j<=ei && nums[i] >2L*nums[j] ){
        //             j++;
        //         }
        //         count += j-(mid+1);
        //     }

        //     return(long) count;
        // }

        // public static void merge(int nums[],int si,int mid,int ei){
        //     int n= nums.length;
        //     int i=si;
        //     int j=mid+1;
        //     int temp[] = new int[ei-si+1];
        //     int k=0;
        //     while(i<=mid && j<=ei){
        //         if(nums[j] >=nums[i]){
        //             temp[k] = nums[i];
        //             i++;k++;
        //         }else{
        //             temp[k] = nums[j];
        //             j++;k++;
        //         }
              

            // }
            // while(i<=mid){
            //     temp[k++] = nums[i++];
                
            // }
            // while(j<=ei){
            //     temp[k++] = nums[j++];
            // }

            // for(int l=si, m=0; m<temp.length; l++,m++){
            //   nums[l] = temp[m];
            // }
        
}