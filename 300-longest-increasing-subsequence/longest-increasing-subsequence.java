class Solution {
    public int lowerBound(ArrayList<Integer> temp,int x){
        int low =0;
        int high = temp.size()-1;
        int ans =0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(temp.get(mid) >=x){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;

    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        int len =1;
        for(int i=1;i<n;i++){
            if(nums[i] >temp.get(temp.size()-1)){
                temp.add(nums[i]);
                len++;
            }else{
                int ind = lowerBound(temp,nums[i]);
                temp.set(ind,nums[i]); 
            }
        }
        return len;
    }
}