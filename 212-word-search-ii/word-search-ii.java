class Solution {
     public class Node{
        Node links[] = new Node[26];
        String word = null;

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
    public void dfs(char board[][], int r,int c,Node node,List<String> ans){
        if(r>=board.length || c>=board[0].length || r<0 || c<0||board[r][c] == '#'  ){
            return;
        }

        char ch = board[r][c];

        Node curr = node.links[ch-'a'];

        if(curr == null){
            return;
        }
        if(curr.word !=null){
            ans.add(curr.word);
            curr.word = null;
        }
        board[r][c] = '#';

        dfs(board,r+1,c,curr,ans);

        dfs(board,r-1,c,curr,ans);

        dfs(board,r,c+1,curr,ans);

        dfs(board,r,c-1,curr,ans);


        board[r][c] = ch;
        return;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie obj = new Trie();

        for(String word:words){
            obj.insert(word);
        }
        List<String> ans = new ArrayList<>();
        int n = board.length;
        int m = board[0].length;
        Node node = obj.root;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(board,i,j,node,ans);
            }
        }
        return ans;
    }
}