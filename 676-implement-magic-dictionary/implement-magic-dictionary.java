class MagicDictionary {
  
   public  List<String> words = new ArrayList<>();
    public MagicDictionary() {
        
    }
    
    public void buildDict(String[] dictionary) {
        for(String word:dictionary){
            words.add(word);
        }
    }
    
    public boolean search(String searchWord) {

        for(String word:words){
            if(word.length() != searchWord.length()){
               continue;
            }
            int diff =0;
            for(int i=0;i<searchWord.length();i++){
                if(searchWord.charAt(i) != word.charAt(i)){
                    diff++;
                }
            }
             if(diff == 1)return true;
        }
        return false;
       
       
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */



































//    public Node{
//         Node links[] = new Node[26];
//         boolean flag = false;
//         List<String> words;
//          public Node(){
//             words = new ArrayList<>();
//         }
//         boolean containsKey(char ch){
//             return links[ch-'a'] != null;
//         }
//         void put(char ch,Node node){
//             links[ch-'a'] = node; 
//         }
//         Node get(char ch){
//             return links[ch-'a'];
//         }
//         void setEnd(){
//             flag = true;
//         }
//         boolean isEnd(){
//             return flag;
//         }
//     }