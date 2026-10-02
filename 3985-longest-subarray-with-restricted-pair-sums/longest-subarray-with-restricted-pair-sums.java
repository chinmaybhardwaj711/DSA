// class Solution {
//     public boolean isSafe(int freq[],int x){
        
//         for(int a=1;a<=x/2;a++){
//             int b = x-a;

//             if(a==b){
//                 if(freq[a] >=2){
//                     return false;
//                 }
//             }else{
//                 if(freq[a] >0 && freq[b] >0){
//                   return false;
//                 }
//             }
            
           
//         }

//         for(int a=1;a+x<=500;a++){

//            int  b = a+x;
//             if(freq[a]>0 && freq[b] >0){
//                 return false;
//             }

//         }
//         return true;
//     }
//     public int maxSubarray(int[] nums) {
//        int freq[] = new int[501];


//        int n = nums.length;
//        int l=0;
//        int ans =0;
//       for(int r=0;r<nums.length;r++){
//         int x = nums[r];
//         while(!isSafe(freq,x)){
//             freq[nums[l]]--;
//             l++;
//         }
//         freq[x]++;
//         ans = Math.max(ans,r-l+1);
//       }
//       return ans;
//     }
// }
class Solution {
    
    public boolean isSafe(int freq[],int x){
        for(int a=1;a<=x/2;a++){
            int b = x-a;
            if(a==b){
                if(freq[a]>=2){
                    return false;
                }
            }else{
                if(freq[a] >0 && freq[b] >0){
                    return false;
                }
            }
        }



        for(int a=1;a+x<=500;a++){
            int b = a+x;
            if( freq[a]>0 && freq[b]>0){
                return false;
            }
        }
        return true;
    }
    public int maxSubarray(int[] nums) {
        int n = nums.length;
        int l =0;
        int ans =0;
        int freq[] = new int[501];
        for(int r=0;r<n;r++){
            while(!isSafe(freq,nums[r])){
                freq[nums[l]]--;
                l++;
             
            }
            freq[nums[r]]++;
             ans = Math.max(ans,r-l+1);

        }
        return ans;
    }
}