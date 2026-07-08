class LFUCache {
    class Node{
        int key;
        int value;
        int freq;
        Node next;
        Node prev;
            Node(int key,int value){
                this.key = key;
                this.value = value;
                freq = 1;
            }


    }
    class DoubleLL{
        Node head;
        Node tail;
        int size;
            DoubleLL(){
                head = new Node(-1,-1);
                tail = new Node(-1,-1);
                head.next = tail;
                tail.prev = head;
                size =0;
            }
            void addFirst(Node node){
                Node next = head.next;
                node.next = next;
                head.next = node;
                next.prev = node;
                node.prev = head;
                size++;
            }

            void remove(Node node){
                Node prev = node.prev;
                Node nxt = node.next;
                prev.next = nxt;
                nxt.prev = prev;
                size--;
            }

        Node removeLast(){
            if(size ==0){
                return null;
            }
            Node last = tail.prev;
            remove(last);
           return last;
        }

    }
    int capacity;
    int minFreq;
    HashMap<Integer,Node> map;
    HashMap<Integer,DoubleLL> freqMap;



    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
        map = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        update(node);
        return node.value;
    }

    
    public void put(int key, int value) {
        if(capacity ==0){
            return ;
        }
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            update(node);
        }else{
            if(map.size() == capacity){
                DoubleLL list = freqMap.get(minFreq);
                Node remove = list.removeLast();
                map.remove(remove.key);
            }

            Node node = new Node(key,value);
            map.put(key,node);

            DoubleLL list = freqMap.getOrDefault(1,new DoubleLL());

            list.addFirst(node);

            freqMap.put(1,list);
            minFreq = 1;

        }
    }

    public void update(Node node){
        int oldFreq = node.freq;
        DoubleLL oldList = freqMap.get(oldFreq);
        oldList.remove(node);

        if(oldList.size == 0 && oldFreq == minFreq){
            minFreq++;
        }
        node.freq++;
        DoubleLL newList = freqMap.getOrDefault(node.freq, new DoubleLL());
        newList.addFirst(node);
        freqMap.put(node.freq,newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */