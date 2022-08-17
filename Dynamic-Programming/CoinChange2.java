/*https://leetcode.com/problems/coin-change-2/*/

class Solution {
    int n;
    Integer[][] table;
    public int change(int amount, int[] coins)
    {
        n = coins.length;
        table = new Integer[n+1][amount+1];
        table[0][amount] = solve(coins,amount,0);
        return table[0][amount];
    }
    private int solve(int[] coins, int amount, int index)
    {
        if (amount == 0) return 1;
        if (table[index][amount] != null) return table[index][amount];
        int result = 0;
        for (int i = index; i < n; ++i)
            if (coins[i] <= amount)
                result += solve(coins, amount-coins[i], i);
        return table[index][amount] = result;
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        int table[]=new int[amount+1];
 
    // Base case (If given value is 0)
    table[0] = 1;
 
    // Pick all coins one by one and update the table[] values
    // after the index greater than or equal to the value of the
    // picked coin
    for(int i=0; i<coins.length; i++)
        for(int j=coins[i]; j<=amount; j++)
            table[j] += table[j-coins[i]];
 
    return table[amount];
    }
}