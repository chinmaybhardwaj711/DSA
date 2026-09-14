class Solution {
    public long shadowPairs(int[] nums) {
        HashMap<Integer,Integer> count = new HashMap<>();
        long res = 0;
        Stack<Integer> s = new Stack<>();
        for(int a:nums){
            while(!s.isEmpty() && s.peek() > a){
                int remove = s.pop();
                count.put(remove,count.get(remove)-1);

               
            }
             res+=s.size()-count.getOrDefault(a,0);
            s.push(a);
            count.put(a,count.getOrDefault(a,0)+1);
        }
        return res;
    }
}