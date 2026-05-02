class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int lps[] = new int[n];
        int prefix = 0;
        int suffix = 1;
        lps[0] = 0;
        while(suffix < n){
            if(s.charAt(prefix) == s.charAt(suffix)){
                lps[suffix] = prefix+1;
                prefix++;suffix++;
            }else{
                if(prefix == 0){
                    lps[suffix] = 0;
                    suffix++;
                }else{
                    prefix = lps[prefix-1];
                }
            }
        }

        return s.substring(0,lps[n-1]);










    }
}