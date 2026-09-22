class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        String start = "0000";
        for(String s:deadends){
            set.add(s);
        }
        if(set.contains(start)){
            return -1;
        }
        Queue<String> q = new LinkedList<>();
       q.offer(start);
        Set<String> vis = new HashSet<>();
        vis.add(start);
        int steps =0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String curr = q.poll();
                if(curr.equals(target)){
                    return steps;
                }
                for(int pos =0;pos<4;pos++){
                    char arr[] = curr.toCharArray();
                    int digit = arr[pos]-'0';
                    digit= (digit+1)%10;
                    arr[pos] =(char)(digit+'0');
                    String next = new String(arr);
                    if(!vis.contains(next) && !set.contains(next)){
                        vis.add(next);
                        q.offer(next);
                    }
                    char arr2[] = curr.toCharArray();
                    digit = arr2[pos]-'0';
                    digit = (digit-1+10)%10;
                    arr2[pos] = (char)( digit +'0');
                    next = new String(arr2);
                     if(!vis.contains(next) && !set.contains(next)){
                        vis.add(next);
                        q.offer(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}