class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left =0;
        int right =0;
        int n = s.length();
        int maxLen = 0;
       int[] Hash = new int[256];
       Arrays.fill(Hash,-1);
       while(right<n){
         if(Hash[s.charAt(right)] != -1){
            if(Hash[s.charAt(right)] >=left){
                left = Hash[s.charAt(right)] +1;
            }
         }
         int len = right-left+1;
             maxLen = Math.max(len,maxLen);
            Hash[s.charAt(right)] = right;
            right++;
        
        }
       return maxLen;

    }
}




        // int left = 0;
        // int maxlen =0;
        // HashSet<Character> set = new HashSet<>();
        // for(int right =0;right<s.length();right++){
        //     while(set.contains(s.charAt(right))){
        //         set.remove(s.charAt(left));
        //         left++;
        //     }
        //     set.add(s.charAt(right));
        //     maxlen = Integer.max(maxlen,right-left+1);
            
   