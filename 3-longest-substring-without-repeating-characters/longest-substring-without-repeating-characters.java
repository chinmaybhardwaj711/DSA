class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxleng = 0;
        HashSet<Character> set = new HashSet<>();

        for(int right =0;right<s.length();right++){
            
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxleng = Math.max(maxleng, right-left +1);
            
        }


        return maxleng;
    }



    public static void main(String args[]){
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}