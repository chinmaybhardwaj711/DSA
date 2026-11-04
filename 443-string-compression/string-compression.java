// class Solution {
//     public int compress(char[] chars) {
//         int n = chars.length;
//         int idx =0;
        
//         for(int i=0;i<chars.length;i++){
//             char ch = chars[i];
//             int count =0;
//             while(i<n && chars[i] == ch ){
//                 i++;count++;
//             }
//             if(count == 1){
//                 chars[idx++] = ch; 
//             }else{
//                 chars[idx++] = ch;
//                 String st = Integer.toString(count);
//                 for(char digit:st.toCharArray()){
//                     chars[idx++] = digit;
//                 }
//             }
//            i--;
//         }
//       return idx;
//     }
// }
// // class Solution {
// //     public int compress(char[] chars) {
// //         int n = chars.length;
// //         StringBuilder sb = new StringBuilder();
// //         int cnt =1;
// //         for(int i=1;i<n;i++){
// //             char prev = chars[i-1];
// //             char curr = chars[i];
// //             if(prev == curr){
// //                 cnt++;
// //             }else{
// //                 sb.append(prev).append(cnt);
// //                 cnt =1;
// //             }
// //         }
// //         return sb.length();
// //     }
// // }


class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
      int idx =0;
      for(int i=0;i<n;){
        char curr = chars[i];
        int cnt =0;
        while(i<n && curr == chars[i]){
            cnt++;
            i++;
        }
        if(cnt ==1){
            chars[idx++] = curr;
        }else{
            chars[idx++] = curr;
            for(char digit:String.valueOf(cnt).toCharArray()){
                chars[idx++]= digit;
            }
        }
      }
      return idx;

    }
}