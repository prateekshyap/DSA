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