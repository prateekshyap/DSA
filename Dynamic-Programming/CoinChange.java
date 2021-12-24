/*https://practice.geeksforgeeks.org/problems/coin-change2448/1/*/

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