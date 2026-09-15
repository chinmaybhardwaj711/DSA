class Solution {
    static List<Long>[]pal = new ArrayList[2];
     static{
         pal[0] = new ArrayList<>();
        pal[1] = new ArrayList<>();

        for(int x=1;x<100000;x++){
            String s =  String.valueOf(x);
            int n = s.length();
            String rev = new StringBuilder(s).reverse().toString();

            long oldPal = Long.parseLong(s.substring(0,n-1)+rev);

            long evenPal = Long.parseLong(s+rev);

            if(oldPal<1000000000L){
                pal[(int)oldPal%2].add(oldPal);
            }
            if(evenPal<1000000000L){
                pal[(int)evenPal%2].add(evenPal);
            }

        }
         Collections.sort(pal[0]);
            Collections.sort(pal[1]);
    }
       
    
    public long minOperations(int[] nums) {
        long ans =0;
      
        for(int x:nums){
              List<Long> list = pal[x%2];

              int index = Collections.binarySearch(list,(long)x);
              if(index<0){
                index = -(index+1);
              }
              Long left = Long.MAX_VALUE;
               Long right = Long.MAX_VALUE;
              if(index>0){
               left = list.get(index-1);
              }
              if(index<list.size()){
               right = list.get(index);
              }

              long dist = Math.min(Math.abs(x-left),Math.abs(x-right));
              ans+=dist/2;
        }
        return ans;
    }
}