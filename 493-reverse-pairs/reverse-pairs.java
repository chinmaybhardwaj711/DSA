class Solution {
    public int reversePairs(int[] nums) {
        return (int) mergeSort(nums,0,nums.length-1);
        
       
    }
     public static long mergeSort(int nums[], int si,int ei){
            if(si>=ei){
                return 0;
            }
            int mid = si+(ei-si)/2;
            long count=0;
            count+=mergeSort(nums, si,mid);
            count+=mergeSort(nums,mid+1,ei);
            count+= countPairs(nums,si,mid,ei);
            merge(nums,si,mid,ei);

            return (long) count;
        }

        public static long countPairs(int nums[], int si,int mid,int ei){
            int j=mid+1;
            int count =0;
            
            for(int i=si;i<=mid;i++){
                while(j<=ei && nums[i] >2L*nums[j] ){
                    j++;
                }
                count += j-(mid+1);
            }

            return(long) count;
        }

        public static void merge(int nums[],int si,int mid,int ei){
            int n= nums.length;
            int i=si;
            int j=mid+1;
            int temp[] = new int[ei-si+1];
            int k=0;
            while(i<=mid && j<=ei){
                if(nums[j] >=nums[i]){
                    temp[k] = nums[i];
                    i++;k++;
                }else{
                    temp[k] = nums[j];
                    j++;k++;
                }
              

            }
            while(i<=mid){
                temp[k++] = nums[i++];
                
            }
            while(j<=ei){
                temp[k++] = nums[j++];
            }

            for(int l=si, m=0; m<temp.length; l++,m++){
              nums[l] = temp[m];
            }
        }
}