// class Solution {
//     public boolean isPalindromic(String s) {
//         StringBuilder sb = new StringBuilder();

//         for(int i=0;i<s.length();i++){
//             char ch = s.charAt(i);
//             int ascii = (int)ch;

//             String b = String.format("%8s",Integer.toBinaryString(ascii)).replace(' ','0');
//             sb.append(b);
//         }

//         int i=0;
//         int j= sb.length()-1;
//         while(i<j){
//             if(sb.charAt(i) != sb.charAt(j)){
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }
// }
class Solution {
    public boolean isPalindromic(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            int c = (int)ch;
            
            String b = String.format("%8s",Integer.toBinaryString(c)).replace(' ','0');
            sb.append(b);
        }
        int i=0;
        int j= sb.length()-1;
        while(i<j){
            if(sb.charAt(i) != sb.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}