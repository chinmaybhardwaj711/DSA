// class Solution {
//     public int scheduleCourse(int[][] courses) {
//         Arrays.sort(courses,(a,b)->Integer.compare(a[1],b[1]));

//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));

//         int i=0;
//         int n = courses.length;
//         int time =0;
//         while(i<n){
//             int deadline = courses[i][1];
//             int duration = courses[i][0];
          
//             time+=duration;
//             pq.offer(courses[i][0]);
//             i++;

//               if(time > deadline){
//                int remove = pq.poll();
//                 time -=remove;

//             }
//         }
//         return pq.size();

//     }
// }

class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        int n = courses.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));

        int time =0;
        int i=0;
        while(i<n){
            int deadline = courses[i][1];
            int duration = courses[i][0];
            pq.offer(duration);

            time+=duration;
            if(time>deadline){
               int longest = pq.poll();
               time-=longest;
            }
            i++;
        }
        return pq.size();
    }
}