class Solution {
    public boolean isPalindrome(String s) {
        String s2 = s.toLowerCase();
      StringBuilder str = new StringBuilder();
       int n = s2.length();
      
       for(int i=0;i<n;i++){
         char ch = s2.charAt(i);
        if(Character.isLetterOrDigit(ch)){
            str.append(ch);
        }
        
       }


       int n2 = str.length();
        for(int i=0;i<n2/2;i++){
            if( str.charAt(i) != str.charAt(n2-1-i)){
                return false;
            }
           
        }


        return true;

    }
}