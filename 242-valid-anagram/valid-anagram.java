class Solution {
    public boolean isAnagram(String s, String t) {

    //     if(s.length() != t.length()){
    //         return false;
    //     }
    //   char s2[] = s.toCharArray();
    //   char t2[] = t.toCharArray();

    //   Arrays.sort(s2);
    //   Arrays.sort(t2);

    //   return Arrays.equals(s2, t2);










        char char1[] = s.toCharArray();
        char char2[] = t.toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);

        if(Arrays.equals(char1,char2)){
            return true;
        }else {
            return false;
        }
        // for(int i=0;i<s.length();i++){
        //       if(char1[i] != char2[i]){
        //     return false;
        //     }
        // }



       
    
      









    }
}