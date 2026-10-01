class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int max=0;
        for(int it:nums){
            map.put(it,map.getOrDefault(it,0)+1);
            max = Math.max(max,map.get(it));
        }

        int ans[] = new int[n];
       
        int idx =0;
        for(int round=1;round<=max;round++){
            for(int key:map.keySet()){
                if(map.get(key) >= round){
                    ans[idx++] = key;
                   
                }
            }
        }

        return ans;

        
    }
}