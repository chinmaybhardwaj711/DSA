// class Solution {
//     public boolean repeatedSubstringPattern(String s) {
//         String doubled = s+s;
//         String trim = doubled.substring(1,doubled.length()-1);
//         if(trim.contains(s)){
//             return true;
//         }
//         return false;
//     }
// }


























// // brute force
// // class Solution {
// //     public boolean repeatedSubstringPattern(String s) {
// //         int n = s.length();

// //         for(int len=1;len<=n/2;len++){
// //             if(n%len != 0){
// //                 continue;
// //             }
// //             boolean isTrue = true;

// //             for(int i =len;i<n;i++){
// //                 if(s.charAt(i) != s.charAt(i%len)){
// //                     isTrue = false;
// //                     break;
// //                 }

// //             }
// //             if(isTrue){
// //                 return true;
// //             }
           
// //         }
// //         return false;
         
// //     }
// // }


class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int lps[] = new int[n];
        int i =1;
        lps[0] = 0;
        int len =0;


        while(i<n){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len !=0){
                    len = lps[len-1];

                }else{
                    lps[i] =0;
                    i++; 
                }
            }
        }
        int lastLps = lps[n-1];
        int period = n-lastLps;

        return lastLps>0 && n%period ==0;


    }
}