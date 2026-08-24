class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);

        long time =0;
        int i=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        while(i<courses.length){
            int duration = courses[i][0];
            int deadline = courses[i][1];

            time+=duration;
            pq.offer(duration);
        

            if(time>deadline){
                int longest = pq.poll();
                time-=longest;
            }
            i++;
        }
        return pq.size();
    }
}