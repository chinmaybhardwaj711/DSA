class Solution {
    public static boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        HashSet<Integer> seen =new HashSet<>();
        for(int num:nums){
            if(seen.contains(num)){
                return true;
            }else{
                seen.add(num);
            }
        }
        return false;
    }

    public static void main(String args[]){
        int nums[] = {1,2,3,1};
       System.out.println(containsDuplicate(nums));
    }
}
