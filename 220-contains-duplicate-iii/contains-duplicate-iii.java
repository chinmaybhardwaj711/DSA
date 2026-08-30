class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeMap<Long,Integer> map = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            if(i>indexDiff){
                long old = nums[i-indexDiff-1];
                int freq = map.get(old);
                if(freq == 1){
                    map.remove(old);
                }else{
                    map.put(old,freq-1);
                }
            }
            long curr = nums[i];
            long upper = curr+valueDiff;
            long lower = curr-valueDiff;

            Long cand = map.ceilingKey(lower);
            if(cand != null  && cand<=upper){
                return true;
            }
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        return false;
    }
}