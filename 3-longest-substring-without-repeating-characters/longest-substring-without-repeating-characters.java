class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int left =0;
        // int right =0;
        // int maxLen = 0;
        // int n = s.length();
        // int Hash[] = new int[256];
        // Arrays.fill(Hash,-1);

        // while(right<n){
        //     char ch = s.charAt(right);
        //     if(Hash[ch] != -1){
        //         if(Hash[ch] >= left){
        //            left = Hash[ch] +1;
        //         }
        //     }
        //     int len = right-left+1;
        //     maxLen = Math.max(len,maxLen);

        //     Hash[ch]= right;


        // }
        // return maxLen;


        int []Hash = new int[256];
        int left =0;
        Arrays.fill(Hash,-1);
        int n = s.length();
        int maxLen =0;
        int right = 0;
        while(right<n){
            char ch = s.charAt(right);
            if(Hash[ch] != -1){
                if(Hash[ch] >=left){
                    left = Hash[ch] +1;
                }
            }
            int len = right-left+1;
            maxLen = Math.max(maxLen,len);
            Hash[ch] = right;
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
            
   