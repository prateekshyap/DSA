/*https://practice.geeksforgeeks.org/problems/coin-change2448/1/*/

class Solution {
    Long[][] storedWays;
    public long count(int S[], int m, int n) {
        storedWays = new Long[m+1][n+1];
        storedWays[m][n] = solve(S, m, n, 0);
        return storedWays[m][n];
    }
    public long solve(int[] coins, int n, int amount, int index)
    {
        if (amount == 0)
        {
            storedWays[index][amount] = (long)1;
            return 1;
        }
        if (storedWays[index][amount] != null) return storedWays[index][amount];
        int i;
        long result = 0;
        for (i = index; i < n; ++i)
            if (coins[i] <= amount)
                result += solve(coins, n, amount-coins[i], i);
        storedWays[index][amount] = result;
        return result;
    }
}

class Solution
{
    public long count(int S[], int m, int n) 
    {
        long[] table = new long[n+1];
        table[0] = 1;
        for (int i = 0; i < m; ++i)
            for (int j = S[i]; j <= n; ++j)
                table[j] += table[j-S[i]];
        return table[n];
    }
}

/*https://leetcode.com/problems/coin-change/*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins); //sort the coins
        if (amount == 0) return 0; //return 0 for 0 amount
        int[] table = new int[amount+1];

        //for each value from 1 to amount
        for (int i = 1; i <= amount; ++i)
        {
            //store a bigger value in the table
            table[i] = amount+1;

            //for each coin
            for (int j = 0; j < coins.length; ++j)
            {
                //if the coin is bigger than the amount being considered, then break
                if (coins[j] > i)
                    break;

                //we can't update the cell table[i] if the table[i-coins[j]] cell is 0 and i-coins[j] is non-zero
                if (!(i != coins[j] && table[i-coins[j]] == 0))
                    table[i] = Math.min(table[i],table[i-coins[j]]+1);
            }

            //if the table is not updated, store 0
            if (table[i] == amount+1)
                table[i] = 0;
        }

        //return the final value
        return table[amount] == 0 ? -1 : table[amount];
    }
}


class Solution {
    int n, minCoins;
    Integer[][] coinCounts;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int i = 0, j = coins.length-1, temp;
        n = coins.length;
        minCoins = Integer.MAX_VALUE;
        coinCounts = new Integer[n+1][amount+1];
        solve(coins, amount, n-1, 0);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
    public void solve(int[] coins, int amount, int index, int coinCount)
    {
        if (amount == 0)
        {
            if (coinCount < minCoins) minCoins = coinCount;
            return;
        }
        if (coinCounts[index][amount] != null && coinCount >= coinCounts[index][amount]) return;
        coinCounts[index][amount] = coinCount;
        int i;
        for (i = index; i >= 0; --i)
            if (coins[i] <= amount)
                solve(coins, amount-coins[i], i, coinCount+1);
    }
}

class Solution {
    int n, minCoins;
    Integer[][] coinCounts;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int i = 0, j = coins.length-1, temp;
        n = coins.length;
        minCoins = Integer.MAX_VALUE;
        coinCounts = new Integer[n+1][amount+1];
        solve(coins, amount, n-1, 0);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
    public void solve(int[] coins, int amount, int index, int coinCount)
    {
        if (index == -1) return;
        if (amount == 0)
        {
            if (coinCount < minCoins) minCoins = coinCount;
            return;
        }
        if (coinCounts[index][amount] != null && coinCount >= coinCounts[index][amount]) return;
        coinCounts[index][amount] = coinCount;
        
        
        if (coins[index] <= amount)
            solve(coins, amount-coins[index], index, coinCount+1);
        solve(coins, amount, index-1, coinCount);
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int a, c;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int coin : coins)
        {
            for (a = coin; a <= amount; ++a)
            {
                dp[a] = Math.min(dp[a],dp[a-coin]+1);
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}