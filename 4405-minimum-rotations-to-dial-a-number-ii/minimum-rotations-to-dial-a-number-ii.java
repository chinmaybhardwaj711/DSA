class Solution {
    public int minRotations(int n, String s) {
        int prev =0;int currSum =0;
        int gain =0;
        int last = s.charAt(n-1)-'0';
     for(char ch:s.toCharArray()){
        int curr = ch-'0';
        currSum+= dist(prev,curr);
        gain = Math.max(gain,dist(prev,curr)-dist(prev,last));
        prev = curr;
     }
     return currSum-gain;
    }
    public int dist(int a,int b){
        int diff = Math.abs(a-b);
        return Math.min(diff,10-diff);
    }
}