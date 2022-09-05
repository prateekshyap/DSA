/*https://leetcode.com/problems/meeting-rooms-iii/*/

class Room implements Comparable<Room>
{
    int roomNo;
    int endTime;
    Room(int r, int et)
    {
        roomNo = r;
        endTime = et;
    }
    
    @Override
    public int compareTo(Room r)
    {
        if (this.endTime == r.endTime) return this.roomNo-r.roomNo;
        return this.endTime-r.endTime;
    }
    
    @Override
    public String toString()
    {
        return "("+this.roomNo+" "+this.endTime+")";
    }
}

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int M = meetings.length;
        int[] arrival = new int[M], end = new int[M];
        int i = 0;
        Arrays.sort(meetings,(a,b)->(a[0]-b[0])); //sort meetings according to arrival time
        for (int[] meeting : meetings)
        {
            arrival[i] = meeting[0];
            end[i] = meeting[1];
            ++i;
        }
        PriorityQueue<Room> heap = new PriorityQueue<Room>();
        for (i = 0; i < n; ++i)
            heap.add(new Room(i,0)); //add all the rooms to heap
        int[] room = new int[n];
        
        for (i = 0; i < M; ++i) //for each meeting
        {
            ArrayList<Room> empties = new ArrayList<Room>();
            while (!heap.isEmpty()) //till heap has more elements
            {
                if (heap.peek().endTime > arrival[i]) break; //if no more meeting can be ended, break
                Room r = heap.poll(); //extract a meeting from heap
                r.endTime = 0; //close the meeting
                empties.add(r); //add to empty list
            }
            for (Room r : empties) heap.add(r); //for each room in the empty list, add them to heap
            Room emptyRoom = heap.poll(); //extract the smallest room available
            int delay = Math.max(0,emptyRoom.endTime-arrival[i]); //get the delay duration
            heap.add(new Room(emptyRoom.roomNo,end[i]+delay)); //add the delay to the end time
            ++room[emptyRoom.roomNo]; //increment the usage of the corresponding room
        }
        int max = 0, result = -1;
        for (i = 0; i < n; ++i)
        {
            if (room[i] > max)
            {
                max = room[i]; //get the max
                result = i; //get the corresponding index
            }
        }
        return result;
    }
}