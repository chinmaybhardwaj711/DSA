class MyCalendarTwo {
      List<int[]> bookings = new ArrayList<>();
        List<int[]> overlaps = new ArrayList<>();
    public MyCalendarTwo() {
      

    }
    
    public boolean book(int startTime, int endTime) {
        for(int overlap[]:overlaps){
            int start = Math.max(startTime,overlap[0]);
            int end = Math.min(endTime,overlap[1]);
            if(start<end){
                return false;
            }

        }

        for(int booking[]:bookings){
            int start2 = Math.max(startTime,booking[0]);
            int end2 = Math.min(endTime,booking[1]);

            if(start2<end2){
                overlaps.add(new int[]{start2,end2});
            }
        }
        bookings.add(new int[]{startTime,endTime});
        
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */