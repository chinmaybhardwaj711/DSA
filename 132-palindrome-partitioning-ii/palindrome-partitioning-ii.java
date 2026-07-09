class Solution {
    public boolean isPalindrome(int i,int j,String s,int n){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;

    }
    public int f(int i,String s, int n, int dp[]){
        if(i == n){
            return 0;
        }
        if(dp[i] != -1)return dp[i];
        int min = Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            if(isPalindrome(i,j,s,n)){
                int cost = 1 + f(j+1,s,n,dp);
                min = Math.min(cost,min);
            }
        }
        return dp[i] =min;
    }
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp,-1);

        return f(0,s,n,dp)-1;
    }
}