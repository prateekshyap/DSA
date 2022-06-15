/*https://binarysearch.com/problems/Rod-Cutting*/

import java.util.*;

class Solution {
    int calculate(int[] prices, int n, int[] dp) {
        if (n <= 0)
            return 0;
        if (dp[n] != 0)
            return dp[n];
        for (int i = 0; i < n; i++)
            dp[n] = Math.max(dp[n], prices[i] + calculate(prices, n - i - 1, dp));
        return dp[n];
    }
    public int solve(int[] prices, int n) {
        int[] dp = new int[n+1];
        return calculate(prices, n, dp);
    }
}