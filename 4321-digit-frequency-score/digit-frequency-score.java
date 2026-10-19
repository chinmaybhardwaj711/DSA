class Solution {
    public int digitFrequencyScore(int n) {
        char ch[] = String.valueOf(n).toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:ch){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int score =0;
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            char x = entry.getKey();
            int y = entry.getValue();

            int digit = x-'0';
            score+=digit*y;
        }
        return score;

    }
}