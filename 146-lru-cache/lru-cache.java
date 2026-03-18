class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
         Node next;

        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer,Node> map = new HashMap<>();
    Node head;
    Node tail;
    int capacity;

    void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void addToFront(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node; 
    }
  

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
        // this.capacity = capacity;
        // head = new Node(0,0);
        // tail = new Node(0,0);

        // head.next = tail;
        // tail.prev = head;    
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        addToFront(node);

        return node.value;
        // if(!map.containsKey(key)){
        //     return -1;
        // }
        // Node node = map.get(key);
        //  removeNode(node);
        //  addToFront(node);
        //  return node.value;
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addToFront(node);
        }else{
            Node node = new Node(key,value);
            addToFront(node);
            map.put(key,node);

            if(map.size()> capacity){
                Node lr = tail.prev;
                removeNode(lr);
                map.remove(lr.key);
            }


        }
    }    
   
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */