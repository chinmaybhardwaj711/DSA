class MapSum {
     class Node{
        Node links[] = new Node[26];
        int prefixSum =0;
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
 
     Node root;
     HashMap<String,Integer> map ;

    public MapSum() {

        root = new Node();
        map = new HashMap<>();
    }

    
    public void insert(String key, int val) {
        int oldval = map.getOrDefault(key,0);

        int diff = val-oldval;
        map.put(key,val);
        Node node = root;
        for(int i=0;i<key.length();i++){
            char ch = key.charAt(i);
            if(!node.containsKey(ch)){
               node.put(ch,new Node());
            }
           
            node = node.get(ch);
             node.prefixSum+=diff;
        }


    }
    
    public int sum(String prefix) {
        Node node = root;

        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(!node.containsKey(ch)){
                return 0;
            }
             node = node.get(ch);  
            
        }
        return node.prefixSum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */