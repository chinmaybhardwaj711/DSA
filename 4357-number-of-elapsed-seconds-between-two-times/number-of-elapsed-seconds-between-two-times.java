// class Solution {
//     public int secondsBetweenTimes(String startTime, String endTime) {
//         String start[] = startTime.split(":");
//         String end[] = endTime.split(":");

//         int startsec = Integer.parseInt(start[0])*3600 + Integer.parseInt(start[1])*60 + Integer.parseInt(start[2]);
//         int endsec = Integer.parseInt(end[0])*3600 + Integer.parseInt(end[1])*60 + Integer.parseInt(end[2]);
     
//      return endsec-startsec;
//         // String start[] = startTime.split(":");
//         // String end[] = endTime.split(":");

//         // int startSec = Integer.parseInt(start[0])*3600+
//         //                 Integer.parseInt(start[1])*60+
//         //                 Integer.parseInt(start[2]);

//         // int endSec = Integer.parseInt(end[0])*3600+
//         //                 Integer.parseInt(end[1])*60+
//         //                 Integer.parseInt(end[2]);

//         // return endSec-startSec;
        
//     }
// }



class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        String start[] = startTime.split(":");
        String end[] = endTime.split(":");

        
            int s =Integer.parseInt(start[0])*3600 + Integer.parseInt(start[1])*60 + Integer.parseInt(start[2]);
            int e = Integer.parseInt(end[0])*3600 + Integer.parseInt(end[1])*60 + Integer.parseInt(end[2]);

       return e-s;
       
    }
}