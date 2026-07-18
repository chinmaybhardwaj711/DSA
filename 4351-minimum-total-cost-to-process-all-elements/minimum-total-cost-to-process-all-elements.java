class Solution {
    static long mod =  1000000007;
    public static  int minimumCost(int[] nums, int k) {
        long resources = k;
        long oprndone = 0;
        

        for(int x:nums){
            if(resources <x){
                long need = x - resources;
                long ops = (need+k-1)/k;   

                resources += ops*(long)k;
                oprndone +=ops;

            }
            resources -= x;
        }
        
            if (oprndone % 2 == 0) {
            long a = (oprndone / 2) % mod;
            long b = (oprndone + 1) % mod;
            return (int) ((a * b) % mod);
        } else {
            long a = oprndone % mod;
            long b = ((oprndone + 1) / 2) % mod;   
            return (int) ((a * b) % mod);
        }
    }
}