class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String words[] = sentence.trim().split("\\s+");
        
        for(int i=0;i<words.length;i++){
            String word = words[i];
            for(String root:dictionary){
                if(word.startsWith(root)){
                   word = root;
                }
            }
            words[i] = word;

        }
        return String.join(" ",words);

    }
}