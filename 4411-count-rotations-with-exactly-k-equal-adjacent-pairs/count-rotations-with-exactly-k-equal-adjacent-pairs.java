class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();
        int same =0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == s.charAt((i+1)%n)){
                same++;
            }
        }
              if(k==same){
                return n-same;
            }

            if(k== same-1){
                return same;
            }
        return 0;
    }
}







// class Solution {
//     public int countRotations(String s, int k) {
//         int ans =0;
//         int n = s.length();
//         for(int start=0;start<n;start++){
//             int equal =0;

//             String rotated = s.substring(start) + s.substring(0,start);

//             for(int i=0;i<n-1;i++){
//                 if(rotated.charAt(i) == rotated.charAt(i+1)){
//                     equal++;
//                 }
//             }

//             if(equal == k){
//                 ans++;
//             }
//         }
//         return ans;
//     }
// }