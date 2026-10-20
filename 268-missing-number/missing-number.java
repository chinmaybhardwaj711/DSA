class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor =0;
        for(int num:nums){
            xor = xor^num;
        }

        for(int i=0;i<=n;i++){
            xor= xor^i;
        }
        return xor;
    }
}


// class Solution {
//     public int missingNumber(int[] nums) {
//         int n = nums.length;
//         HashSet<Integer> set = new HashSet<>();

//         for(int num:nums){
//             set.add(num);
//         }

//         for(int i=0;i<=n;i++){
//             if(!set.contains(i)){
//                 return i;
//             }
//         }
//         return 0;
//     }
// }