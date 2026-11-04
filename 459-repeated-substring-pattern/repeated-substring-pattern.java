class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        for(int len=1;len<=n/2;len++){
            if(n%len != 0){
                continue;
            }
            boolean isTrue = true;

            for(int i =len;i<n;i++){
                if(s.charAt(i) != s.charAt(i%len)){
                    isTrue = false;
                    break;
                }

            }
            if(isTrue){
                return true;
            }
           
        }
        return false;
         
    }
}