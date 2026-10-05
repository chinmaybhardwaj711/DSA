class Solution {
    public int minRotations(int n, String s) {
        int last = s.charAt(n-1)-'0';
        int gain =0;int prev =0;int sum =0;
        for(char c:s.toCharArray()){
            int curr = c-'0';
            sum+=dist(prev,curr);
            gain = Math.max(gain,dist(prev,curr)-dist(prev,last));
            prev = curr;
        }
        return sum-gain;
    }
    public int dist(int a,int b){
        int d = Math.abs(a-b);
        return Math.min(d,10-d);
    }
}