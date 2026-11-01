class Solution {
     public class Node{
        Node links[] = new Node[26];
        String word ;

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
            node.word = word;
        }

     }
     public void dfs(Node node,List<String> ans){
        if(ans.size() == 3){
            return;
        }
       
        if(node.word != null){
            ans.add(node.word);
        }
        for(int i=0;i<26;i++){

            if(node.links[i] !=null){
                Node child = node.links[i];
                dfs(child,ans);
            }
        }
        

     }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie obj = new Trie();

        for(String product:products){
            obj.insert(product);
        }

        List<List<String>> ans = new ArrayList<>();
   
        Node node = obj.root;
        for(int i=0;i<searchWord.length();i++){
             List<String> list = new ArrayList<>();
            char ch = searchWord.charAt(i);
            if( node != null && node.containsKey(ch)){
                node = node.get(ch);
                dfs(node,list);
               
            }else{
                node = null;
            }
             ans.add(list);
        }
        return ans;

    }
}