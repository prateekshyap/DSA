/*https://leetcode.com/problems/the-latest-time-to-catch-a-bus/*/

class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        
        int nextBusTime = 0, nextIndex = 0, p = 0;
        ArrayList<TreeSet<Integer>> busStructures = new ArrayList<TreeSet<Integer>>();
        while (nextIndex < buses.length) //for all buses
        {
            TreeSet<Integer> nextBus = new TreeSet<Integer>(); //create a new bus
            nextBusTime = buses[nextIndex++]; //get the time of the bus
            //till there are more passengers remaining, their arrival time is before the bus arrives and bus capacity is not full
            while (p < passengers.length && passengers[p] <= nextBusTime && nextBus.size() < capacity)
                nextBus.add(passengers[p++]); //add the current passenger to current bus
            busStructures.add(nextBus); //add the current bus to bus structure
        }
        int start, end, timer = -1, busIndex = buses.length-1;
        TreeSet<Integer> lastBus; //this will contain the buses from the end

        //if last bus is full then we'll start from the last passenger on the bus other wise we'll start from the bus's arrival time
        end = busStructures.get(busIndex).size() == capacity ? busStructures.get(busIndex).last() : buses[busIndex];
        while (busIndex >= 0) //for all buses
        {
            lastBus = busStructures.get(busIndex); //get the bus
            //if current bus is empty then we'll end at the previous bus's arrival time+1 otherwise we'll end at the earliest passenger on the current bus
            start = lastBus.size() == 0 ? (busIndex > 0 ? buses[busIndex-1]+1 : 1) : lastBus.first();
            --busIndex; //decrease the bus index
            for (timer = end; timer >= start; --timer) //move from end to start
                if (!lastBus.contains(timer)) //if the timer is not present in the bus
                    return timer; //we can arrive on that time instance
            end = start-1; //set end to start-1
        }
        return timer; //return timer at the end, i.e. is there are no empty slots then we have to arrive at the first position
    }
}