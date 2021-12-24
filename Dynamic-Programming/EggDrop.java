/*https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1*/

class Solution 
{
    static int eggDrop(int n, int k) 
    {
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i < n+1; ++i)
        {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for (int i = 0; i < k+1; ++i)
            dp[1][i] = i;
        for (int i = 2; i < n+1; ++i)
        {
            for (int j = 2; j < k+1; ++j)
            {
                dp[i][j] = Integer.MAX_VALUE;
                int res = -1;
                for (int p = 1; p <= j; ++p)
                {
                    res = Math.max(dp[i-1][p-1],dp[i][j-p]);
                    dp[i][j] = Math.min(dp[i][j],res);
                }
                dp[i][j] += 1;
            }
        }
        return dp[n][k];
    }
}