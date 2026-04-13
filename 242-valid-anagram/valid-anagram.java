class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
      char s2[] = s.toCharArray();
      char t2[] = t.toCharArray();

      Arrays.sort(s2);
      Arrays.sort(t2);

      return Arrays.equals(s2, t2);

    }
}