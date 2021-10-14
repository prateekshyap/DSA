/*https://leetcode.com/problems/minimum-cost-for-tickets/*/

/*Prateekshya*/

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] table = new int[days.length];
        for (int i = table.length-1; i >= 0; --i) //consider the days in reverse order
        {
        	/*case-1*/
        	//add the cost for one day pass
            int day = costs[0];

            //if the next day is available, add it's minimum cost
            if (i+1 < table.length) day += table[i+1];

            /*case-2*/
            //store the current day
            int currDay = days[i];

            //add a week
            currDay += 6;

            //next index is the day where we need to buy the next ticket
            int nextTicket = i+1;
            while (nextTicket < days.length && days[nextTicket] <= currDay)
                ++nextTicket;

            //add the cost for one week
            int week = costs[1];

            //if the next ticket day is available, add it's minimum cost
            if (nextTicket < table.length) week += table[nextTicket];

            /*case-3*/
            //store the current day
            currDay = days[i];

            //add a month
            currDay += 29;

            //next index is the day where we need to buy the next ticket
            nextTicket = i+1;
            while (nextTicket < table.length && days[nextTicket] <= currDay)
                ++nextTicket;

            //add the cost for one month
            int month = costs[2];

            //if the next ticker day is available, add it's minimum cost
            if (nextTicket < table.length) month += table[nextTicket];

            //store the minimum out of all three for the current day
            table[i] = Math.min(day,Math.min(week,month));
        }

        //minimum for the first day will be the answer
        return table[0];
    }
}