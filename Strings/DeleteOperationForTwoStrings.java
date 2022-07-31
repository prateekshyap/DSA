/*https://leetcode.com/problems/delete-operation-for-two-strings/*/

class Solution {
    public int minDistance(String s1, String s2) {
        int i, j, m = s1.length(), n = s2.length();
        int dp[][] = new int[m+1][n+1];
        for (i = m-1; i >= 0; --i)
            dp[i][n] = dp[i+1][n]+1;
        for (j = n-1; j >= 0; --j)
            dp[m][j] = dp[m][j+1]+1;
        for (i = m-1; i >= 0; --i)
        {
            for (j = n-1; j >= 0; --j)
            {
                if (s1.charAt(i) == s2.charAt(j)) dp[i][j] = dp[i+1][j+1];
                else dp[i][j] = Math.min(dp[i+1][j]+1,dp[i][j+1]+1);
            }
        }
        return dp[0][0];
    }
}