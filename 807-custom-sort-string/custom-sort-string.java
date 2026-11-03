class Solution {
  
    public String customSortString(String order, String s) {
        int n = s.length();
    //     HashMap<Character,Integer> map = new HashMap<>();
    //    for(int i=0;i<order.length();i++){
    //         char ch = order.charAt(i);
    //         map.put(ch,i);
    //    }

       int freq[] = new int[26];
       for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
       }

       StringBuilder ans = new StringBuilder();

       for(char ch:order.toCharArray()){
            while(freq[ch-'a'] >0){
                ans.append(ch);
                freq[ch-'a']--;
            }

       }
       for(char ch='a';ch<='z';ch++){
            while(freq[ch-'a'] >0){
                ans.append(ch);
                freq[ch-'a']--;
            }
       }
       return ans.toString();



    }
}