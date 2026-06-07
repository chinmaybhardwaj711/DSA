class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        //step1
        int n =s.length();
        int first[] = new int[26];
        int last[] = new int[26];
        Arrays.fill(first,Integer.MAX_VALUE);
        for(int i=0;i<s.length();i++){
            int ch =s.charAt(i)-'a';
            first[ch] = Math.min(first[ch],i);
            last[ch] = i;
        }

        List<int[]> intervals = new ArrayList<>();
        //step2 valid intervals
        for(int c =0;c<26;c++){
            if(first[c] == Integer.MAX_VALUE)continue;
            int start = first[c];
            int end = last[c];
            boolean valid = true;

            for(int j=start;j<end;j++){
                int d = s.charAt(j) -'a';
                if(first[d] <start){
                    valid = false;
                    break;
                }
                end = Math.max(end,last[d]);
            }
            if(valid){
                intervals.add(new int[]{start,end});
            }
        }



        //step 3 greedy step by end
        intervals.sort((a,b) -> a[1]-b[1]);//ascending
        int prevEnd = -1;
        List<String> result = new ArrayList<>();
        for(int interval[]: intervals){
            if(interval[0] >prevEnd){
                result.add(s.substring(interval[0], interval[1]+1));
                prevEnd = interval[1];
            }


        }

        return result;
        
    }
}