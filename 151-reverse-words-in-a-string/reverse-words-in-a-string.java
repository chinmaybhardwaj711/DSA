class Solution {
    public String reverseWords(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        int n = s.length();
        String ans = "";
        for(int i=0;i<n;i++){
            String word = "";
            while(i<n && s2.charAt(i) != ' '){
                word += s2.charAt(i);
                i++;
            }
            String reverse = new StringBuilder(word).reverse().toString();
            if(reverse.length() >0){
                ans += " " + reverse;
            }

        }
       return ans.trim();
    }
}