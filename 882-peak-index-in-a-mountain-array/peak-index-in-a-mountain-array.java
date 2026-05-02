class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int right = n-1; int left = 0;
        while(left<right){
            int mid = left + (right-left)/2;
            if(arr[mid] < arr[mid+1]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
        // for(int i=0;i<n;i++){
        //     if(arr[i] > Max){
        //         Max = arr[i];
        //          index = i;
        //     }

        // }
        // return index;

     
    }
}