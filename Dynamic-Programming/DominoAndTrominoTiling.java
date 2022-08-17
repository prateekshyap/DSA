/*https://leetcode.com/problems/domino-and-tromino-tiling/*/

class Solution {
    final static int m = (int)1e9+7;
    public int numTilings(int n) {
        int[] dp = new int[Math.max(4,n+1)];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        if (n <= 3) return dp[n];
        for (int i = 4; i <= n; ++i)
            dp[i] = (dp[i]+(2*dp[i-1])%m+dp[i-3])%m;
        return dp[n];
    }
}