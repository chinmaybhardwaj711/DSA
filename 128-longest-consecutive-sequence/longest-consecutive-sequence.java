class Solution {
    public int longestConsecutive(int[] nums) {
//         HashSet<Integer> st = new HashSet<>();
//         int n = nums.length;
//         if(n==0)return 0;
//         for(int i=0;i<nums.length;i++){
//             st.add(nums[i]);
//         }
        
//         int longest =-1;
//         for(int it:st){
//             if(!st.contains(it-1)){
//                 int start = it;
//                int cnt=1;
//                 while(st.contains(it+1)){
//                     cnt++;
//                     it = it+1;
//                 }
//                  longest = Math.max(cnt,longest);
//             }
//         }
       

//         return longest;
//     }
// }












Arrays.sort(nums);
int n = nums.length;
if(n==0){
    return 0;
}

HashSet<Integer> set = new HashSet<>();

for(int i=0;i<nums.length;i++){
    set.add(nums[i]);
}
int longest = Integer.MIN_VALUE;
for(int it:set){
    if(!set.contains(it-1)){
        int start = it;
        int cnt =1;

        while(set.contains(it+1)){
            cnt++;
            it++;
        }
        longest = Math.max(longest,cnt);
    }
}
return longest;

    }
}












