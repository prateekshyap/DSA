/*https://leetcode.com/problems/my-calendar-i/*/

class Event implements Comparable<Event>
{
    int startTime, endTime;
    Event(int s, int e)
    {
        this.startTime = s;
        this.endTime = e;
    }
    
    @Override
    public int compareTo(Event other)
    {
        return this.endTime-other.endTime;
    }
    
    @Override
    public String toString()
    {
        return "("+this.startTime+"->"+this.endTime+")";
    }
}
class MyCalendar {
    List<Event> events;
    public MyCalendar() {
        events = new ArrayList<Event>();
    }
    
    public boolean book(int start, int end) {
        for (Event event : events)
        {
            if (start < event.endTime && end > event.startTime)
                return false;
        }
        events.add(new Event(start,end));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

 class MyCalendar {
  private TreeMap<Integer, Integer> map = new TreeMap<>();
  public MyCalendar() {

  }

  public boolean book(int start, int end) {
    Map.Entry<Integer, Integer> e = map.floorEntry(end - 1);
    if (e != null && e.getValue() > start) return false;
    map.put(start, end);
    return true;
  }
}