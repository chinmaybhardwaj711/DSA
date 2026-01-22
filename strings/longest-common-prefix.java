class Solution {
    public  static String longestCommonPrefix(String[] strs) {

        if(strs.length == 0 || strs == null){
            return "";
        }
       for(int i=0;i<strs[0].length();i++){
        char currchar = strs[0].charAt(i);

        for(int j=1;j<strs.length;j++){

            if(i>=strs[j].length() || strs[j].charAt(i) != currchar){
                return strs[0].substring(0,i);
            }
        }
       }
       return strs[0];
    }


    public static void main(String args[]){
        String[] strs = {"flower","flow","flight"};
        longestCommonPrefix(strs);
    }
}
