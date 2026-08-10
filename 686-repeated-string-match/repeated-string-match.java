class Solution {
    public int repeatedStringMatch(String a, String b) {
        int n = a.length();
        int m = b.length();
        int cnt = (n+m-1)/n;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<cnt;i++){
            sb.append(a);
        }
        if(sb.toString().contains(b)){
            return cnt;
        }
        sb.append(a);
        if(sb.toString().contains(b)){
            return cnt+1;
        }
        return -1;
    }
}