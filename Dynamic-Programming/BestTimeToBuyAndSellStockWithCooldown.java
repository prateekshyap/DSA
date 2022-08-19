/*https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/*/

/*Memoization*/
class Solution {
    Integer[][] table;
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
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
        if (day == -1) return 0;
        if (day == 0) return table[day][hold] = hold == 1 ? -prices[0] : 0;
        
        if (table[day][hold] != null) return table[day][hold];
        
        /*
        If we do not have any share on the current day, that means
            Either we didn't have any shares on the previous day
            Or we had a share on the previous day and we sold it on the current day and got the profit
        */
        if (hold == 0) return table[day][hold] = Math.max(solve(prices, day-1, hold),solve(prices, day-1, 1-hold)+prices[day]);
        /*
        If we have a share on the current day, that means
            Either we had a share on the previous day
            Or we didn't have any share on the previous day and we bought a new share on the current day so we lost
            price[i]
        */
        return table[day][hold] = Math.max(solve(prices, day-1, hold),solve(prices, day-2, 1-hold)-prices[day]);
    }
}

/*Tabulation*/
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int n = prices.length;
        int[][] table = new int[n][2];
        table[0][1] = -prices[0];
        table[1][0] = Math.max(table[0][0],table[0][1]+prices[1]);
        table[1][1] = Math.max(-prices[1],table[0][1]);
        for (int i = 2; i < n; ++i)
        {
            table[i][0] = Math.max(table[i-1][0],table[i-1][1]+prices[i]);
            table[i][1] = Math.max(table[i-1][1],table[i-2][0]-prices[i]);
        }
        return table[n-1][0];
    }
}