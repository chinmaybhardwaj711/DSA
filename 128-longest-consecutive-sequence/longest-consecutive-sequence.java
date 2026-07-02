class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        int n = nums.length;
        if(n==0)return 0;
        for(int i=0;i<nums.length;i++){
            st.add(nums[i]);
        }
        
        int longest =-1;
        for(int it:st){
            if(!st.contains(it-1)){
                int start = it;
               int cnt=1;
                while(st.contains(it+1)){
                    cnt++;
                    it = it+1;
                }
                 longest = Math.max(cnt,longest);
            }
        }
       

        return longest;
    }
}