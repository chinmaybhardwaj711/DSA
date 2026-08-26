class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int i=0;
        int j =0;
        int n = nums1.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(i<n){
            while(j<n){
                int sum =nums1[i] + nums2[j];
                map.put(sum, map.getOrDefault(sum,0)+1);
                j++;

            }
            i++;
            j=0;
        }
        i=0;
        int cnt =0;
        while(i<n){
            while(j<n){
                int sum2 = nums3[i]+nums4[j];
                int needed = -sum2;
                if(map.containsKey(needed)){
                    cnt+= map.get(needed);
                }
                j++;
            }
            i++;
            j=0;
        }

        return cnt;
    }
}