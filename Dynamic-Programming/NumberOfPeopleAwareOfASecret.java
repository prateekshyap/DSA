/*https://leetcode.com/problems/number-of-people-aware-of-a-secret/*/

/*
totalAware stores the number of people who are aware of the secret on the current day.
newEntries[i] stores the number of people who came to know about the secret on ith day.
possibleShare stores how many people may share the secret
cantshare stores how many people cannot share the secret due to incomplete delay period
newEntrants stores how many people came to know about the secret
*/

class Solution {
    private static final int m = (int)1e9+7;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] newEntries = new int[n+1];
        int totalAware = 0, day;
        
        totalAware = 1; //for all days till the delay, only 1 person knows the secret
        newEntries[1] = 1; //new entries for the 1st day is 1 and for the rest is 0
        
        int possibleShare = 0, cantShare = 0, newEntrants = 0;
        for (day = delay+1; day <= n; ++day) //for each day starting from the next day of delay
        {
            possibleShare = totalAware; //get the number of people who may share
            
            possibleShare -= day-forget > 0 ? newEntries[day-forget] : 0; //subtract the number of people who will forget on the same day
            if (possibleShare < 0) possibleShare += m; //rebalancing due to mod operation
            
            newEntrants = possibleShare-cantShare; //store the number of new entrants, the people who cannot share due to incomplete delay period will be subtracted
            if (newEntrants < 0) newEntrants += m; //rebalancing due to mod operation
            
            newEntries[day] = newEntrants; //store the new entrants for current day
            
            totalAware = (possibleShare+newEntrants)%m; //store the total active people for current day
            
            cantShare -= newEntries[day-delay+1]; //slide the window for the people who cannot share the secret for the next day
            if (cantShare < 0) cantShare += m; //rebalancing due to mod operation
            cantShare = (cantShare+newEntries[day])%m; //slide the window for the people who cannot share the secret for the next day
        }
        
        return totalAware;
    }
}