class RandomizedSet {
    HashMap<Integer,Integer> map;
    ArrayList<Integer> list;
    Random random;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
       
        if(map.containsKey(val)){
           return false;
        }
         map.put(val,list.size());
          list.add(val);
          return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        int lastIndex = list.size()-1;
        int lastVal = list.get(lastIndex);
        list.set(index,lastVal);
        map.put(lastVal,index);
        list.remove(lastIndex);
        map.remove(val);
        return true; 

    }
    
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */