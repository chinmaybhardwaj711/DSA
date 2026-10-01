class Solution {
     public record Pair(int a,int b){};

    
    public int maxEqualAdjacentPairs(int[] nums) {
        int cnt =0;
        int n = nums.length;
        int max =0;
        HashMap<Pair,Integer> map = new HashMap<>();
        for(int i=0;i<n-1;i++){
            if(nums[i] == nums[i+1]){
                cnt++;
            }else{
                int x = Math.min(nums[i],nums[i+1]);
                int y = Math.max(nums[i],nums[i+1]);
                Pair pair = new Pair(x,y);
                int gain= map.getOrDefault(pair,0)+1;
                map.put(pair,gain);
                max = Math.max(max,gain);

            }
        }
        return max+cnt;
        
    }
}