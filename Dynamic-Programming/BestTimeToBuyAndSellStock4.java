/*https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/*/
/*https://practice.geeksforgeeks.org/problems/maximum-profit4657/1*/

/*extension of at most twice*/
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0) return 0;
        int i, j, n = prices.length;
        int[][] table = new int[2][k];
        
        for (i = 0; i < k; ++i)
            table[0][i] = Integer.MIN_VALUE;
        
        for (i = 0; i < n; ++i)
        {
            table[0][0] = Math.max(table[0][0],-prices[i]);
            table[1][0] = Math.max(table[1][0],table[0][0]+prices[i]);
            for (j = 1; j < k; ++j)
            {
                table[0][j] = Math.max(table[0][j],table[1][j-1]-prices[i]);
                table[1][j] = Math.max(table[1][j],table[0][j]+prices[i]);
            }
        }
        return table[1][k-1];
    }
}

/*Recursion*/
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) return 0;
        return solve(prices, prices.length-1, k, 0);
    }
    private int solve(int[] prices, int day, int t, int hold)
    {
        if (day == 0) return hold == 1 ? -prices[0] : 0;
        if (t == 0) return 0;
        
        if (hold == 0) return Math.max(solve(prices, day-1, t, hold),solve(prices, day-1, t, 1-hold)+prices[day]);
        return Math.max(solve(prices, day-1, t, hold),solve(prices, day-1, t-1, 1-hold)-prices[day]);
    }
}

/*Memoization*/
class Solution {
    Integer[][][] table;
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) return 0;
        int n = prices.length;
        table = new Integer[n][k+1][2];
        table[n-1][k][0] = solve(prices, n-1, k, 0);
        return table[n-1][k][0];
    }
    private int solve(int[] prices, int day, int t, int hold)
    {
        /*
        If we are on the first day, and we say that we have one share with us, that means we have to buy it on that day only, so -price[i]
        */
        if (day == 0) return table[day][t][hold] = hold == 1 ? -prices[0] : 0;
        /*
        if transactions is 0 we can't do anything, so 0
        */
        if (t == 0) return table[day][t][hold] = 0;
        
        if (table[day][t][hold] != null) return table[day][t][hold];
        
        /*
        If we do not have any share on the current day after k transactions have been initiated, that means
            Either we didn't have any shares on the previous day after k transactions have been initiated
            Or we had a share on the previous day after k transactions have been initiated and we sold it on the current day and got the profit
        */
        if (hold == 0) return table[day][t][hold] = Math.max(solve(prices, day-1, t, hold),solve(prices, day-1, t, 1-hold)+prices[day]);
        /*
        If we have a share on the current day after k transactions have been initiated, that means
            Either we had a share on the previous day after k transactions have been initiated
            Or we didn't have any share on the previous day with k-1 transactions initiated and we bought a new share on the current day so we lost
            price[i] and also a new transaction started i.e. the kth transaction got initiated
        */
        return table[day][t][hold] = Math.max(solve(prices, day-1, t, hold),solve(prices, day-1, t-1, 1-hold)-prices[day]);
    }
}

/*Tabulation*/
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) return 0;
        int n = prices.length;
        int[][][] table = new int[n][k+1][2];
        for (int i = 0; i <= k; ++i)
            table[0][i][1] = -prices[0];
        for (int i = 1; i < n; ++i)
        {
            for (int j = 1; j <= k; ++j)
            {
                table[i][j][0] = Math.max(table[i-1][j][0],table[i-1][j][1]+prices[i]);
                table[i][j][1] = Math.max(table[i-1][j][1],table[i-1][j-1][0]-prices[i]);
            }
        }
        return table[n-1][k][0];
    }
}