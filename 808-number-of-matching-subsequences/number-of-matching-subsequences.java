class Solution {
    public int lowerBound(List<Integer> list,int nxtPos){
        int low = 0;
        int high = list.size()-1;
        int ans =-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(list.get(mid) >=nxtPos){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public int numMatchingSubseq(String s, String[] words) {
        
        //step1 
        int n = s.length();
        List<Integer>[] posn = new ArrayList[26];

        for(int i=0;i<26;i++){
            posn[i] = new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            posn[ch-'a'].add(i);
        }
        int cnt =0;
        for(String word:words){

            int nxtpos = 0;
            boolean match = true;
            for(char ch: word.toCharArray()){
                List<Integer> list = posn[ch-'a'];

                int idx = lowerBound(list,nxtpos);

                if(idx == -1){
                    match = false;
                    break;
                }

                nxtpos = list.get(idx)+1;

            }
            if(match){
                cnt++;
            }
        }
        return cnt;

    }
}





























//brute force

        // int subs = 0;
        // for(String word:words){
        //     int j=0;

        //     for(int i=0;i<s.length() && j<word.length();i++){
        //         if(s.charAt(i) == word.charAt(j)){
        //             j++;
        //         }
        //         if(j == word.length()){
        //             subs++;
        //         }
                
        //     }
            
          

        // }
        //   return subs;