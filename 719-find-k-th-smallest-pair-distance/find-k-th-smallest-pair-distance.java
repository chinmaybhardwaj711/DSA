class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);
        int low=0;
        int high = nums[n-1]-nums[0];

        while(low<=high){
            int mid = low+(high-low)/2;
            int cnt = count(nums,mid);
            if(cnt>=k){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;

    }
    public int count(int nums[],int mid){
        int left =0;
        int n = nums.length;
        int cnt=0;
        for(int right=0;right<n;right++){

            while(nums[right]-nums[left] >mid){
                left++;
            }
            cnt+=right-left;
        }
        return cnt;
    }
}