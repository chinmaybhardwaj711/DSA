class Solution {
    public int leastInterval(char[] tasks, int n) {
       int freq[] = new int[26];
       for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
       } 

       int maxFreq = 0;
       for(int i=0;i<freq.length;i++){
            maxFreq = Math.max(maxFreq,freq[i]);
       }

       int countMax =0;
       for(int i=0;i<freq.length;i++){
        if(freq[i] == maxFreq){
            countMax++;
        }
       }
       int slots = (maxFreq-1)*(n+1) +countMax;
       return Math.max(slots,tasks.length);
    }
}