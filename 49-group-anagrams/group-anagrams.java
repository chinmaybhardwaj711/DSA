class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    //  HashMap<String,List<String>> map = new HashMap<>();
    //  for(String str: strs){
    //     char[] chars = str.toCharArray();
    //     Arrays.sort(chars);

    //     String key = new String(chars);

    //     map.putIfAbsent(key,new ArrayList<>());

    //     map.get(key).add(str);
    //  }

    //  return new ArrayList<>(map.values());


//aproach 2 (optimised)
   HashMap<String,List<String>> map= new HashMap<>();
   for(String str: strs){
    int count[] = new int[26];

    for(char ch: str.toCharArray()){
        count[ch-'a']++;
    }
    StringBuilder keyBuilder = new StringBuilder();
    for(int num:count){
        keyBuilder.append("#").append(num);
    }
    String key = keyBuilder.toString();

    map.putIfAbsent(key,new ArrayList<>());
    map.get(key).add(str);
   }

   return new ArrayList<>(map.values());

    
    }
}