class Solution {
    public long maxAlternatingSum(int[] nums) {
        long neg = Long.MIN_VALUE/2;
        long p = neg;
        long n = neg;
        long pd = neg;
        long nd = neg;

        long ans =neg;
        for(long x:nums){
            long plus = Math.max(x,n+x);
            long minus = p-x;
            long plusD = Math.max(nd+x,p);
            long minusD = Math.max(pd-x,n);


            p = plus;
            n = minus;
            pd = plusD;
            nd = minusD;

            ans = Math.max(ans,Math.max(Math.max(p,n),Math.max(pd,nd)) );

        }
        return ans;
    }
}