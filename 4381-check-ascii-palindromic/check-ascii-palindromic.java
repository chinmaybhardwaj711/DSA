class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int ascii = (int)ch;

            String b = String.format("%8s",Integer.toBinaryString(ascii)).replace(' ','0');
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