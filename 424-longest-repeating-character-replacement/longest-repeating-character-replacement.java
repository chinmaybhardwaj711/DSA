// class Solution {
//     public int characterReplacement(String s, int k) {
//         HashMap<Character,Integer> map = new HashMap<>();
//         int left =0;int maxFreq = 0;
//         int maxLen =0;
//         for(int right=0;right<s.length();right++){
//             Character ch = s.charAt(right);
//             map.put(ch,map.getOrDefault(ch,0)+1);
//             maxFreq  = Math.max(maxFreq,map.get(ch));

//             if((right-left+1)-maxFreq <=k){
//                 int len = right-left+1;
//                 maxLen = Math.max(maxLen,len);
//             }
//             if(right-left+1-maxFreq >k){
//                 Character ch2 = s.charAt(left);
//                 map.put(ch2, map.get(ch2)-1);
//                 if(map.get(ch2) ==0){
//                     map.remove(ch2);
//                 }
//                 left++;
//             }
//         }
//         return maxLen;

//     }
// }


class Solution {
    public int characterReplacement(String s, int k) {
        int left =0;int maxLen =0;int maxFreq=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
             maxFreq = Math.max(maxFreq,map.get(ch));
            if((right-left+1)-maxFreq >k){
                char ch2 = s.charAt(left);
                map.put(ch2,map.get(ch2)-1);
                if(map.get(ch2) == 0){
                    map.remove(ch2);
                }
                left++;
            }
            int len = right-left+1;
                maxLen = Math.max(len,maxLen);
        }
        return maxLen;
    }
}