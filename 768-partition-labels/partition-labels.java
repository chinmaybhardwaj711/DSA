class Solution {
    public List<Integer> partitionLabels(String s) {
        int last[] = new int[26];
        int n = s.length();
        for(int i=0;i<n;i++){
            last[s.charAt(i) - 'a'] = i;
        }
        int end =0;
        List<Integer> ans = new ArrayList<>();
        int start =0;
        for(int i=0;i<n;i++){
            int currLast = last[s.charAt(i)-'a'];
            end = Math.max(end,currLast);
            if(i == end){
                ans.add(end-start+1);
                start= i+1;
            }
        }
        return ans;
    }
}