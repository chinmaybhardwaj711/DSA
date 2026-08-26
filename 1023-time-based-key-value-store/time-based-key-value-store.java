// class TimeMap {
//     public class Pair{
//         String value;
//         int timeStamp;
        

//         public Pair(String value,int timeStamp){
//             this.value = value;
//               this.timeStamp = timeStamp;
//         }

       
//     }
//      HashMap<String,ArrayList<Pair>> map;
//     public TimeMap() {
//         map = new HashMap<>();
//     }
    
//     public void set(String key, String value, int timestamp) {
//         if(!map.containsKey(key)){
//             map.put(key,new ArrayList<>());
//         }
//       map.get(key).add(new Pair(value,timestamp));

//     }
    
//     public String get(String key, int timestamp) {
//         if(!map.containsKey(key)){
//             return "";
//         }

//         ArrayList<Pair> list = map.get(key);

//         int left = 0;
//         int right = list.size()-1;
//         int ans = -1;

       
//         while(left<=right){
//              int mid = left + (right-left)/2;
//             if(list.get(mid).timeStamp <= timestamp){
//                 ans = mid;

//                 left = mid+1;
//             }else{
//                 right = mid-1;
//             }
//         }

//         if(ans ==-1){
//             return "";
//         }
//         return list.get(ans).value;

//     }
// }

// /**
//  * Your TimeMap object will be instantiated and called as such:
//  * TimeMap obj = new TimeMap();
//  * obj.set(key,value,timestamp);
//  * String param_2 = obj.get(key,timestamp);
//  */

class TimeMap {
    class Pair{
        String value;
        int timestamp;

        public Pair(String value,int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    HashMap<String,ArrayList<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
       map.get(key).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return ""; 
        }
        ArrayList<Pair> list = map.get(key);
        int left =0;
        int ans =-1;
        int right = list.size()-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(list.get(mid).timestamp <=timestamp){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        if(ans == -1){
            return "";
        }

        return list.get(ans).value;

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */