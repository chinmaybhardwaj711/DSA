class Solution {
    
    public boolean isPalindrome(String s){
        String s1 = s;
        String s2 = new StringBuilder(s1).reverse().toString();
        return s2.equals(s1);
    }
    void getPartitions(String s,List<String> comb, List<List<String>> ans){
        if(s.length() ==0){
            ans.add(new ArrayList<>(comb));
            return ;
        }

        for(int i=0;i<s.length();i++){
            String part = s.substring(0,i+1);
            if(isPalindrome(part)){
                comb.add(part);
                getPartitions(s.substring(i+1),comb,ans);
                comb.remove(comb.size()-1);
            }
        }
    }
    
    
    
    
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> comb = new ArrayList<>();

        getPartitions(s,comb,ans);


        return ans;
    }
}