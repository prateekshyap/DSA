/*https://leetcode.com/problems/my-calendar-ii/*/

class MyCalendarTwo {
    List<int[]> calendar, overlaps;
    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] doubleBooking : overlaps)
            if (doubleBooking[0] < end && doubleBooking[1] > start)
                return false;
        for (int[] booking : calendar)
            if (booking[0] < end && booking[1] > start)
                overlaps.add(new int[]{Math.max(start,booking[0]),Math.min(end,booking[1])});
        calendar.add(new int[]{start,end});
        return true;
    }
}
/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
 