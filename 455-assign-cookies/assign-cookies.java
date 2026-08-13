class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // int i=0;
        // int j=0;
        // Arrays.sort(g);
        // Arrays.sort(s);
    
        // while(j<s.length && i<g.length){
        //     if(s[j] >=g[i]){{
              
        //         i++;
        //     }}
        //     j++;
        // }
        // return i;














        int i=0;
        int n = g.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int j=0,cnt =0;
        while(i<g.length && j<s.length){
            
            if(g[i] <=s[j]){
                cnt++;
                i++;
            }
            j++;

        }
        return cnt;
    }
}