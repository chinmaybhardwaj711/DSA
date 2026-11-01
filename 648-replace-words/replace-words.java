// class Solution {
//     public String replaceWords(List<String> dictionary, String sentence) {
//         String words[] = sentence.trim().split("\\s+");
        
//         for(int i=0;i<words.length;i++){
//             String word = words[i];
//             for(String root:dictionary){
//                 if(word.startsWith(root)){
//                    word = root;
//                 }
//             }
//             words[i] = word;

//         }
//         return String.join(" ",words);

//     }
// }
// class Solution {
//     public String replaceWords(List<String> dictionary, String sentence) {
//         String words[] = sentence.trim().split("\\s+");

//         for(int i=0;i<words.length;i++){
//             String word = words[i];
//             for(String root:dictionary){
//                 if(word.startsWith(root)){
//                     if(root.length() <word.length()){
//                         word = root;
//                     }
                    
//                 }

//             }
//              words[i] = word;
//         }
//         return String.join(" ",words);
//     }
// }































// class Solution {
//     public String replaceWords(List<String> dictionary, String sentence) {
//         String words[] = sentence.trim().split("\\s+");
        
//         for(int i=0;i<words.length;i++){
//             String word = words[i];
//             for(String root:dictionary){
//                 if(word.startsWith(root)){
//                    word = root;
//                 }
//             }
//             words[i] = word;

//         }
//         return Strings.join(" ",words);

//     }
// }


class Solution {
    public class Node{
        Node links[] = new Node[26];
        boolean flag = false;

         public Node(){

        }
        boolean containsKey(char ch){
            return links[ch-'a'] != null;
        }
        void put(char ch,Node node){
            links[ch-'a'] = node; 
        }
        Node get(char ch){
            return links[ch-'a'];
        }
        void setEnd(){
            flag = true;
        }
        boolean isEnd(){
            return flag;
        }
    }
    public class Trie{
        Node root;

        public Trie(){
            root = new Node();
        }

        void insert(String word){
            Node node = root;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if(!node.containsKey(ch)){
                    node.put(ch,new Node());
                }
                node = node.get(ch);

            }
            node.setEnd();
            
        }
        String search(String word){
            Node node = root;
            StringBuilder prefix = new StringBuilder();
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if(!node.containsKey(ch)){
                    return word;
                }
                prefix.append(ch);
                node = node.get(ch);
                if(node.isEnd()){
                    return prefix.toString();
                }

            }
            return word;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        
        Trie obj = new Trie();

        for(String word:dictionary){
            obj.insert(word);
        }

        String words[] = sentence.trim().split("\\s+");
        for(int i=0;i<words.length;i++){
           words[i] = obj.search(words[i]);
        }
        return String.join(" ",words);
    }
}