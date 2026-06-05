class Solution {
    class Pair{
        String first;
        int second;

        Pair(String first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> s = new HashSet<String>();
        q.add(new Pair(beginWord,1));

        for(int i=0;i<wordList.size();i++){
            s.add(wordList.get(i));
        }
        s.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps =q.peek().second;
            q.remove();

            if(word.equals(endWord)) return steps;
            //word = hat
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[]charWord = word.toCharArray();
                    charWord[i] = ch;
                    String replacedWord = new String(charWord);
                    if(s.contains(replacedWord)){
                        s.remove(replacedWord); // mark visited
                        q.add(new Pair(replacedWord,steps+1));
                    }
                }
            }
        }

        return 0;
    }
}