/*https://leetcode.com/problems/minimum-number-of-refueling-stops/*/

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int curDistance = startFuel;
		int refuels = 0; // refill times
		int i = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
		for (; curDistance < target; refuels++) 
        {
			while (i < stations.length && stations[i][0] <= curDistance)
				pq.offer(stations[i++][1]); // add gas for each station that is earlier than curDistance
			if (pq.isEmpty())
				return -1;
			curDistance += pq.poll();
		}

		return refuels;
	}
}