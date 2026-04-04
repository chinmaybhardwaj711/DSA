class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
     
     for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        if(entry.getValue() >= 2){
            return entry.getKey();
        }
        
     }
     return -1;
    } 
       
      

    
}