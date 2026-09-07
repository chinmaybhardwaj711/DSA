class Solution {
    
    public int solve(String s, int start, int end,int k){
        if(start>end){
            return 0;
        }
        int freq[] = new int[26];
        for(int i=start;i<=end;i++){
            freq[s.charAt(i) - 'a']++;
        }
        for(int i=start;i<=end;i++){
            int idx = s.charAt(i)-'a';
            if(freq[idx] <k){
                int left = solve(s,start,i-1,k);
                int right = solve(s,i+1,end,k);
                  return Math.max(left,right);
            }
          
        }

    return end-start+1;
        
    }
    public int longestSubstring(String s, int k) {
        return solve(s,0,s.length()-1,k);
    }
}