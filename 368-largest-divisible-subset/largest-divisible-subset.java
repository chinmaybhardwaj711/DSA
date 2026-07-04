class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        Arrays.fill(dp,1);
        
        int maxi =1;
        int lastind = 0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            hash[i] = i;
            for(int prev=0;prev<i;prev++){
                if(nums[i] % nums[prev] ==0 && 1+dp[prev] >dp[i]){
                    dp[i] = 1+dp[prev];
                    hash[i] = prev;
                }
            }
            if(dp[i] > maxi){
                maxi= dp[i];
                lastind = i;
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[lastind]);
        while(hash[lastind] != lastind){
            lastind = hash[lastind];
            temp.add(nums[lastind]);
        }
        Collections.reverse(temp);

        return temp;
    }
}