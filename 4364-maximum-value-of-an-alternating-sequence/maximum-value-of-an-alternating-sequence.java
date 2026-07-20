class Solution {
    public long maximumValue(int n, int s, int m) {
        
        if(n==1){
            return s;
        }
        n--;

        //case 1
        long mcnt1 = (n+1)/2;
        long onecnt1 = n-mcnt1;
        
        //case 2
        long onecnt2 = (n+1)/2;
        long mcnt2 = n-onecnt2;


        long ans1 = (long)s + m *mcnt1 -onecnt1;
        long ans2 = (long)s + m *mcnt2 -onecnt2;

        if(n%2 == 0){
            ans1++;
        }else{
            ans2++;
        }       

        return Math.max(ans1,ans2);
    }
}