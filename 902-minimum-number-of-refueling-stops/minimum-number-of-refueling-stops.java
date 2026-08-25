class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int maxDist = startFuel;
        int i=0;
        int n = stations.length;
        int stops =0;
        if(maxDist>=target){
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        while(maxDist <target){
            while(i<n && stations[i][0] <=maxDist){
                pq.offer(stations[i][1]);
                i++;
            }
            if(pq.size() ==0){
                return -1;
            }
           
            maxDist += pq.poll();
            stops++;
        }
        return stops;
    }
}