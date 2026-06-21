class Solution {
    public void dfs(int idx,StringBuilder sb,int n,int k,int cost,List<String> ans){
        if(cost>k){
            return;
        }
        if(idx == n){
            ans.add(sb.toString());
            return;
        }

        //choice 0
        sb.append('0');
        dfs(idx+1,sb,n,k,cost,ans);
        sb.deleteCharAt(sb.length()-1);


        //choice 1
        if ( sb.length() == 0 || (sb.charAt(sb.length()-1) != '1')){
            sb.append('1');
            dfs(idx+1,sb,n,k,cost+idx,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateValidStrings(int n, int k) {
        List<String> ans = new ArrayList<>();
        int cost =0;
        dfs(0,new StringBuilder(),n,k,cost,ans);
        return ans;
    }
}