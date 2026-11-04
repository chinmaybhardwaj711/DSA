class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();

        for(int i=0;i<allowed.length();i++){
            char ch = allowed.charAt(i);
            set.add(ch);
        }
        int cnt =0;
        for(String word:words){
           boolean isTrue =true;
           for(char ch:word.toCharArray()){
            if(!set.contains(ch)){
                isTrue = false;
                break;
            }
            
           }
           if(isTrue){
            cnt++;
           }
           

        }
        return cnt;
    }
}