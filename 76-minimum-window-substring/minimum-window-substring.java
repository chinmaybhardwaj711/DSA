// // class Solution {
// //     public String minWindow(String s, String t) {
// //         if(s.length() < t.length()){
// //             return "";
// //         }

// //         int freq[] = new int[128];

// //         for(int i=0;i<t.length();i++){
// //             freq[t.charAt(i)]++;
// //         }
// //         int left =0;
// //         int count =t.length();

// //         int minLen = Integer.MAX_VALUE;
// //         int start =0;
// //         for(int right =0;right<s.length();right++){
// //             char ch = s.charAt(right);
// //            if(freq[ch] >0){
// //             count--;
// //            }
// //            freq[ch]--;

// //           while(count ==0){
// //             int len = right - left+1;
// //             if(len <minLen){
// //                 minLen = len;
// //                 start = left;
// //             }
// //             char leftChar = s.charAt(left);

// //             freq[leftChar]++;
// //             if(freq[leftChar] >0){
// //                 count++;
// //             }
// //             left++;


// //           }
// //         }

// //         return minLen == Integer.MAX_VALUE? "": s.substring(start,start+minLen);

// //         }
// // }
// class Solution {
//     public String minWindow(String s, String t) {
//         if(s.length() <t.length()){
//             return "";
//         }
//         int freq[] = new int[128];

//         for(int i=0;i<t.length();i++){
//             freq[t.charAt(i)]++;
//         }

//         int count =0;
//         int start =0;
//         int minLen = Integer.MAX_VALUE;

//         int left =0;
//         for(int right=0;right<s.length();right++){
//             char c = s.charAt(right);
//             if(freq[c] >0){
//                 count++;
//             }
//             freq[c]--;

//             while(count == t.length()){
//                 if(right-left+1<minLen){
//                     minLen = right-left+1;
//                     start = left;
//                 }
//                 char remove = s.charAt(left);
//                 freq[remove]++;
//                 if(freq[remove] >0){
//                     count--;
//                 }
//                 left++;

//             }
//         }
//         if(minLen == Integer.MAX_VALUE){
//             return "";
//         }
//         return s.substring(start,start+minLen);
//     }
// }
// class Solution {
//     public String minWindow(String s, String t) {
//         int freq[] = new int[128];

//         for(int i=0;i<t.length();i++){
//             freq[s.charAt(i)]++;
//         }

//         int count =0;
//         int start =0;
//         int minLen = Integer.MAX_VALUE;

//         int left =0
//         for(int right=0;right<s.length();right++){
//             char c = s.charAt(right);
//             if(freq[c] >0){
//                 count++;
//             }
//             freq[c]--;

//             if(count == t.length()){
//                 if(right-left+1<minLen){
//                     minLen = right-left+1;
//                     start = left;
//                 }
//                 char remove = s.charAt(left);
//                 freq[remove]++;
//                 if(freq[remove] >0){
//                     count--;
//                 }
//                 left++;

//             }
//         }
//         if(minLen = Integer.MAX_VALUE){
//             return "";
//         }
//         return s.substring(start,start+minLen);
//     }
// }
class Solution {
    public String minWindow(String s, String t) {
        int freq[] = new int[128];
        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)]++;
        }


        int left =0;
        int start =0;
        int cnt=0;
        int minLen =Integer.MAX_VALUE;
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            if(freq[ch] >0){
                cnt++;
            }
            freq[ch]--;

            while(cnt ==t.length()){
                if(right-left+1<minLen){
                    minLen = right-left+1;
                    start =left;
                }
                char remove = s.charAt(left);
                freq[remove]++;
                if(freq[remove] >0){
                    cnt--;
                }
                left++;
            }
        }
        if(minLen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start+minLen);
    }
}    