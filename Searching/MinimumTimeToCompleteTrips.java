/*https://leetcode.com/problems/minimum-time-to-complete-trips/*/

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low = 1, high = (long)1e15;
        System.out.println(high);
        while (low < high)
        {
            long mid = low+(high-low)/2;
            if (isPossible(mid, totalTrips, time))
                high = mid;
            else low = mid+1;
        }
        return high;
    }
    private boolean isPossible(long timeLimit, int totalTrips, int[] times)
    {
        long trips = 0;
        for (int time : times)
        {
            trips += timeLimit/time;
            if (trips >= totalTrips) return true;
        }
        return trips >= (long)totalTrips;
    }
}