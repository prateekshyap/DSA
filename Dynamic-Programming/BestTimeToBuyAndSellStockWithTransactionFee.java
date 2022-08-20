/**/

/*Memoization*/
class Solution {
    Integer[][] table;
    int fee;
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) return 0;
        this.fee = fee;
        int n = prices.length;
        table = new Integer[n][2];
        table[n-1][0] = solve(prices, n-1, 0);
        return table[n-1][0];
    }
    private int solve(int[] prices, int day, int hold)
    {
        /*
        If we are on the first day, and we say that we have one share with us, that means we have to buy it on that day only, so -price[i]
        */
        if (day == 0) return table[day][hold] = hold == 1 ? -prices[0] : 0;
        
        if (table[day][hold] != null) return table[day][hold];
        
        /*
        If we do not have any share on the current day, that means
            Either we didn't have any shares on the previous day
            Or we had a share on the previous day and we sold it on the current day and got the profit
        */
        if (hold == 0) return table[day][hold] = Math.max(solve(prices, day-1, hold),solve(prices, day-1, 1-hold)+prices[day]-fee);
        /*
        If we have a share on the current day after, that means
            Either we had a share on the previous day
            Or we didn't have any share on the previous day and we bought a new share on the current day so we lost
            price[i]
        */
        return table[day][hold] = Math.max(solve(prices, day-1, hold),solve(prices, day-1, 1-hold)-prices[day]);
    }
}

/*Tabulation*/
class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) return 0;
        int n = prices.length;
        int[][] table = new int[n][2];
        table[0][1] = -prices[0];
        for (int i = 1; i < n; ++i)
        {
            table[i][0] = Math.max(table[i-1][0],table[i-1][1]+prices[i]-fee);
            table[i][1] = Math.max(table[i-1][1],table[i-1][0]-prices[i]);
        }
        return table[n-1][0];
    }
}

class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) return 0;
        int n = prices.length;
        int prevDayNoShare = 0, prevDayWithShare = 0, currDayNoShare = 0, currDayWithShare = 0;
        prevDayWithShare = -prices[0];
        for (int i = 1; i < n; ++i)
        {
            currDayNoShare = Math.max(prevDayNoShare,prevDayWithShare+prices[i]-fee);
            currDayWithShare = Math.max(prevDayWithShare,prevDayNoShare-prices[i]);
            prevDayNoShare = currDayNoShare;
            prevDayWithShare = currDayWithShare;
        }
        return currDayNoShare;
    }
}