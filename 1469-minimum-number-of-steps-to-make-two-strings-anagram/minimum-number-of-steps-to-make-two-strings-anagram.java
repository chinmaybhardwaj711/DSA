class Solution {
    public int minSteps(String s, String t) {
        // char cht[] = t.toCharArray();
        // char chs[] = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
         int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
       
        int minoprn = 0;
        for(int i=0;i<n;i++){
            char ch = t.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.getOrDefault(ch,0)-1);
                if(map.get(ch) ==0){
                    map.remove(ch);
                }

            }else{
                minoprn++;
            }
        }
        return minoprn;
    }
}